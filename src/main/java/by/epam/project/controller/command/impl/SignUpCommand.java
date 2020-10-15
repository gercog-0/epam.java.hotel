package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.*;
import by.epam.project.controller.command.impl.util.CommandUtil;
import by.epam.project.entity.User;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.creator.UserCreator;
import by.epam.project.model.service.EmailMessageService;
import by.epam.project.model.service.impl.UserServiceImpl;
import by.epam.project.validator.impl.UserValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

import static by.epam.project.util.RequestParameterName.*;

public class SignUpCommand implements Command {
    private final UserServiceImpl service = UserServiceImpl.getInstance();
    private final UserValidatorImpl validator = UserValidatorImpl.getInstance();
    private final UserCreator creator = UserCreator.getInstance();

    private static final String ACTIVATION_LINK = "http://localhost:8080/controller?command=confirm_sign_up&login=";
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router;
        HttpSession session = request.getSession();

        try {
            String login = request.getParameter(USER_LOGIN);
            String password = request.getParameter(USER_PASSWORD);
            String email = request.getParameter(USER_EMAIL);
            String name = request.getParameter(USER_NAME);
            String surname = request.getParameter(USER_SURNAME);
            String phone = request.getParameter(USER_PHONE);

            Map<String, String> requestData = service.defineSignUpData(login,
                    password, email, name, surname, phone);

            if (validator.defineIncorrectValues(requestData)) {
                EmailMessageService emailService = EmailMessageService.getInstance();
                User newUser = creator.createUser(login, email, name, surname, phone, User.Role.USER.getRoleId());
                service.signUpUser(newUser);
                service.updatePasswordByLogin(login, password);
                session.removeAttribute(MessageAttribute.SIGN_UP_DATA);
                session.setAttribute(MessageAttribute.ACTIVATION_USER_LOGIN, newUser.getLogin());
                String locale = (String) session.getAttribute(MessageAttribute.LANGUAGE);

                String emailSubjectWithLocale = CommandUtil.makePartWithLocale(locale, PropertiesMessageKey.EMAIL_SUBJECT);
                String emailBodyWithLocale = CommandUtil.makePartWithLocale(locale, PropertiesMessageKey.EMAIL_BODY);

                emailService.makeAndSendActivationEmail(newUser, emailSubjectWithLocale,
                        emailBodyWithLocale, ACTIVATION_LINK);
                router = new Router(Router.Type.REDIRECT, createRedirectURL(request,
                        CommandType.PASSING_ACTIVATION.getNameCommand()));
            } else {
                request.setAttribute(MessageAttribute.SIGN_UP_DATA, requestData);
                router = new Router(PagePath.SIGN_UP);
            }
        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router = new Router(PagePath.ERROR_500);

        }
        return router;
    }
}
