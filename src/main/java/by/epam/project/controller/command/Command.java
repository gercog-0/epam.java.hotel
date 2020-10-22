package by.epam.project.controller.command;

import by.epam.project.controller.Router;

import javax.servlet.http.HttpServletRequest;

import static by.epam.project.util.RequestParameterName.*;

public interface Command {
    Router execute(HttpServletRequest request);

    default String createRedirectURL(HttpServletRequest request, String commandName) {
        final String REDIRECT_QUESTION_MARK = "?";
        final String REDIRECT_EQUAL_SIGN = "=";

        String redirectUrl = request.getContextPath() + request.getServletPath()
                + REDIRECT_QUESTION_MARK + COMMAND + REDIRECT_EQUAL_SIGN + commandName;
        return redirectUrl;
    }
}
