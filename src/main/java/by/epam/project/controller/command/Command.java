package by.epam.project.controller.command;

import by.epam.project.controller.Router;

import javax.servlet.http.HttpServletRequest;

import static by.epam.project.util.RequestParameter.*;

public interface Command {
    Router execute(HttpServletRequest request);

    default String createRedirectURL(HttpServletRequest request, String commandName) {
        String redirectUrl = request.getContextPath() + request.getServletPath() + "?"
                + COMMAND + "=" + commandName;
        return redirectUrl;
    }
}
