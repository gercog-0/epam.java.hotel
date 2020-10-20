package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.CommandType;
import by.epam.project.controller.command.MessageAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.project.util.RequestParameterName.*;
public class LogOutCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(MessageAttribute.USER);
        session.removeAttribute(MessageAttribute.USER_ROLE);
        session.removeAttribute(MessageAttribute.ALL_USERS);
        session.removeAttribute(ROOMS);
        String redirectUrl = createRedirectURL(request, CommandType.PASSING_HOME.getNameCommand());
        Router router = new Router(Router.Type.REDIRECT, redirectUrl);
        return router;
    }
}
