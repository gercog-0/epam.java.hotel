package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.MessageAttribute;
import by.epam.project.controller.command.PagePath;
import by.epam.project.controller.command.PropertiesMessageKey;
import by.epam.project.controller.command.impl.util.CommandUtil;
import by.epam.project.entity.User;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.service.EmailMessageService;
import by.epam.project.model.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.epam.project.util.RequestParameter.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class SignInCommand implements Command {
    private final UserServiceImpl userService = UserServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        HttpSession session = request.getSession();
        // TODO: 09.10.2020 maybe redirect?
        // TODO: 09.10.2020 maybe redirect?
        // TODO: 09.10.2020 maybe redirect?
        // TODO: 09.10.2020 maybe redirect?
        // TODO: 09.10.2020 maybe redirect?
        try {
            String login = request.getParameter(USER_LOGIN);
            String password = request.getParameter(USER_PASSWORD);

            Optional<User> currentUser = userService.signInUser(login, password);
            if (currentUser.isPresent()) {
                User user = currentUser.get();
                session.removeAttribute(MessageAttribute.SIGN_IN_ERROR_MESSAGE);
                if (user.isBanned()) {
                    router.setCurrentPage(PagePath.BANNED_INFO);
                } else if (!user.isActivated()) {
                    router.setCurrentPage(PagePath.ACTIVATION_INFO);
                } else {
                    session.setAttribute(MessageAttribute.USER, user);
                    session.setAttribute(MessageAttribute.USER_ROLE, user.getRole());
                    router.setCurrentPage(PagePath.HOME);
                }
            } else {
                String locale = (String) session.getAttribute(MessageAttribute.LANGUAGE);
                String messageWithLocale = CommandUtil.makePartWithLocale(locale, PropertiesMessageKey.SIGN_IN_INCORRECT_DATA);
                request.setAttribute(MessageAttribute.SIGN_IN_ERROR_MESSAGE, messageWithLocale);
                router.setCurrentPage(PagePath.SIGN_IN);
            }
        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router.setCurrentPage(PagePath.ERROR_404);
        }
        return router;
    }
}
