package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.MessageAttribute;
import by.epam.project.controller.command.PagePath;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.entity.Booking;
import by.epam.project.model.service.impl.BookingServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowAllBookingsCommand implements Command {
    private BookingServiceImpl bookingService = BookingServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router;

        try {
            List<Booking> allBookings = bookingService.findAllBookings();
            request.setAttribute(MessageAttribute.SHOW_COMMAND, true);
            request.setAttribute(MessageAttribute.BOOKINGS, allBookings);
            router = new Router(PagePath.WAITING_BOOKING_ADMIN);
        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router = new Router(PagePath.ERROR_500);
        }
        return router;
    }
}
