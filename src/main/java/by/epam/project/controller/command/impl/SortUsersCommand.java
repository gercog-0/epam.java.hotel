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
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.project.util.RequestParameterName.*;

/**
 * The type Sort users command.
 */
public class SortUsersCommand implements Command {
    private UserServiceImpl userService = UserServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Router router;

        try {
            String sortType = request.getParameter(USER_TYPE_SORT);
            List<User> usersList = (List<User>) session.getAttribute(MessageAttribute.ALL_USERS);
            List<User> sortedUsersList = userService.sortByParameter(usersList, sortType);
            session.setAttribute(MessageAttribute.ALL_USERS, sortedUsersList);
            router = new Router(PagePath.USERS_ADMIN);
        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router = new Router(PagePath.ERROR_500);
        }
        return router;
    }
}
