package by.epam.project.controller.command.impl.page;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Passing to sign up command.
 */
public class PassingToSignUpCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        return new Router(PagePath.SIGN_UP);
    }
}
