package by.epam.project.controller.command.impl.page;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The type Passing to home command.
 */
public class PassingToHomeCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        return new Router(PagePath.HOME);
    }
}
