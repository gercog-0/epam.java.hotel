package by.epam.project.controller.command.impl.page;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class PassingToActiveBookingAdminCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        // TODO: 15.10.2020 spisok komnat 
        return new Router(PagePath.ACTIVE_BOOKING_ADMIN);
    }
}
