package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.MessageAttribute;
import by.epam.project.controller.command.PagePath;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.entity.User;
import by.epam.project.model.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import java.util.Optional;

import static by.epam.project.util.RequestParameterName.USER_LOGIN;

/**
 * Ban user command.
 * The command is responsible for blocking an existing system user.
 */
public class BanUserCommand implements Command {
    private UserServiceImpl userService = UserServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router;
        String loginUser = request.getParameter(USER_LOGIN);
        try {
            Optional<User> foundUser = userService.findUserByLogin(loginUser);
            if (foundUser.isPresent() && foundUser.get().getRole() != User.Role.ADMINISTRATOR) {
                userService.banUser(loginUser);
                request.setAttribute(MessageAttribute.BAN_LOGIN_USER, loginUser);
                router = new Router(PagePath.NOTIFICATION);
            } else {
                router = new Router(PagePath.ERROR_404);
            }
        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router = new Router(PagePath.ERROR_500);
        }
        return router;
    }
}
