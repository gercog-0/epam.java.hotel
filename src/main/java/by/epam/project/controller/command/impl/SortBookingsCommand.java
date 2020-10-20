package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.MessageAttribute;
import by.epam.project.controller.command.PagePath;
import by.epam.project.entity.Booking;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.service.impl.BookingServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.project.util.RequestParameterName.*;

public class SortBookingsCommand implements Command {
    private BookingServiceImpl bookingService = BookingServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router;
        HttpSession session = request.getSession();

        try {
            String sortType = request.getParameter(BOOKING_TYPE_SORT);
            List<Booking> currentPersonalBookings = (List<Booking>) session.getAttribute(MessageAttribute.PERSONAL_BOOKINGS);
            List<Booking> newSortedPersonalBookings = bookingService.sortByParameter(currentPersonalBookings, sortType);
            session.setAttribute(MessageAttribute.PERSONAL_BOOKINGS, newSortedPersonalBookings);
            router = new Router(PagePath.USER_PROFILE);

        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router = new Router(PagePath.ERROR_500);
        }
        return router;
    }
}
