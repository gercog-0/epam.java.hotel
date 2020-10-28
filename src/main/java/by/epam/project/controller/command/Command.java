package by.epam.project.controller.command;

import by.epam.project.controller.Router;

import javax.servlet.http.HttpServletRequest;

import static by.epam.project.util.RequestParameterName.*;

/**
 * The interface Command.
 */
public interface Command {
    /**
     * Execute router.
     *
     * @param request the request
     * @return the router
     */
    Router execute(HttpServletRequest request);

    /**
     * Create redirect url string.
     *
     * @param request     the request
     * @param commandName the command name
     * @return the string
     */
    default String createRedirectURL(HttpServletRequest request, String commandName) {
        final String REDIRECT_QUESTION_MARK = "?";
        final String REDIRECT_EQUAL_SIGN = "=";
        String redirectUrl = request.getContextPath() + request.getServletPath()
                + REDIRECT_QUESTION_MARK + COMMAND + REDIRECT_EQUAL_SIGN + commandName;
        return redirectUrl;
    }
}
