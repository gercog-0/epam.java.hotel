package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.PagePath;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.service.UserService;
import by.epam.project.model.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.epam.project.util.RequestParameter.*;

public class UnBanUserCommand implements Command {
    private UserService userService = UserServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router;
        String loginUser = request.getParameter(USER_LOGIN);
        try {
            userService.banUser(loginUser);
            // TODO: 09.10.2020 redirect to this page again  
            router = new Router();
        } catch (ServiceException exp){
            LOGGER.error(exp);
            router =  new Router(PagePath.ERROR_505);
        }
        return router;
    }
}
