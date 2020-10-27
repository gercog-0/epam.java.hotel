package by.epam.project.controller.filter;

import by.epam.project.controller.command.*;
import by.epam.project.controller.command.impl.EmptyCommand;
import by.epam.project.model.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

import static by.epam.project.controller.command.CommandName.EMPTY_COMMAND;
import static by.epam.project.controller.command.CommandName.PASSING_HOME;
import static by.epam.project.util.RequestParameterName.COMMAND;

/**
 * The type Command security filter.
 */
@WebFilter(filterName = "CommandSecurityFilter")
public class CommandSecurityFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        String commandName = request.getParameter(COMMAND);
        Command currentCommand = CommandProvider.provideCommand(commandName);
        CommandName currentCommandName = EMPTY_COMMAND;
        if (commandName == null) {
            currentCommandName = PASSING_HOME;
        }
        if (currentCommand.getClass() != EmptyCommand.class) {
            currentCommandName = CommandName.valueOf(commandName.toUpperCase());
        }
        User.Role userRole = (User.Role) session.getAttribute(MessageAttribute.USER_ROLE);
        if (userRole == null) {
            userRole = User.Role.GUEST;
        }
        Set<CommandName> commandNameSet;
        switch (userRole) {
            case USER:
                commandNameSet = CommandType.USER.getCommandNames();
                break;
            case ADMINISTRATOR:
                commandNameSet = CommandType.ADMINISTRATOR.getCommandNames();
                break;
            default:
                commandNameSet = CommandType.GUEST.getCommandNames();
                break;
        }
        if (!commandNameSet.contains(currentCommandName)) {
            LOGGER.error("Request error " + currentCommandName);
            request.getRequestDispatcher(PagePath.ERROR_404).forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
