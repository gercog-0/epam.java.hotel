package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.CommandName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Log out command.
 * This command allows an authorized user to log out of the system.
 */
public class LogOutCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        String redirectUrl = createRedirectURL(request, CommandName.PASSING_HOME.toString().toLowerCase());
        Router router = new Router(Router.Type.REDIRECT, redirectUrl);
        return router;
    }
}
