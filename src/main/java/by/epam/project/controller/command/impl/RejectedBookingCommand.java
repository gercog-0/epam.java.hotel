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
import java.util.Optional;

import static by.epam.project.util.RequestParameterName.BOOKING_ID;

/**
 * Rejected booking command.
 * The team is responsible for rejecting the user's booking of a hotel room.
 */
public class RejectedBookingCommand implements Command {
    private BookingServiceImpl bookingService = BookingServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router;

        try {
            String idBooking = request.getParameter(BOOKING_ID);
            Optional<Booking> foundBooking = bookingService.findBookingById(idBooking);
            if (foundBooking.isPresent() && foundBooking.get().getStatus() != Booking.Status.REJECTED) {
                bookingService.updateBookingStatus(idBooking, Booking.Status.REJECTED.getNameStatus());
                request.setAttribute(MessageAttribute.REJECT_BOOKING_ID, idBooking);
                router = new Router(PagePath.NOTIFICATION);
            } else {
                router = new Router(PagePath.ERROR_404);
            }
        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router = new Router(PagePath.ERROR_500);
        }
        return router;
    }
}
