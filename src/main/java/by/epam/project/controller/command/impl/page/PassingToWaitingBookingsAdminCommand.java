package by.epam.project.controller.command.impl.page;

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
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Passing to waiting bookings admin command.
 */
public class PassingToWaitingBookingsAdminCommand implements Command {
    private BookingServiceImpl bookingService = BookingServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Router router;

        try {
            Booking.Status status = Booking.Status.WAITING;
            List<Booking> waitingBooking = bookingService.findBookingsByStatus(status.getNameStatus());
            session.setAttribute(MessageAttribute.BOOKINGS, waitingBooking);
            router = new Router(PagePath.WAITING_BOOKING_ADMIN);
        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router = new Router(PagePath.ERROR_500);
        }
        return router;
    }
}
