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

import static by.epam.project.util.RequestParameterName.*;

/**
 * Approve booking command.
 * This command  is responsible for activating the pending booking.
 */
public class ApproveBookingCommand implements Command {
    private BookingServiceImpl bookingService = BookingServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router;

        try {
            String idBooking = request.getParameter(BOOKING_ID);
            Optional<Booking> foundBooking = bookingService.findBookingById(idBooking);
            if (foundBooking.isPresent() && foundBooking.get().getStatus() == Booking.Status.WAITING) {
                bookingService.updateBookingStatus(idBooking, Booking.Status.PAYMENT.getNameStatus());
                request.setAttribute(MessageAttribute.APPROVE_BOOKING_ID, idBooking);
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
