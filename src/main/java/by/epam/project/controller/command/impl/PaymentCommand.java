package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.MessageAttribute;
import by.epam.project.controller.command.PagePath;
import by.epam.project.controller.command.PropertiesMessageKey;
import by.epam.project.controller.command.impl.util.CommandUtil;
import by.epam.project.model.entity.Booking;
import by.epam.project.model.entity.User;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.service.impl.BookingServiceImpl;
import by.epam.project.model.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static by.epam.project.util.RequestParameterName.BOOKING_ID;

public class PaymentCommand implements Command {
    private BookingServiceImpl bookingService = BookingServiceImpl.getInstance();
    private UserServiceImpl userService = UserServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Router router;

        try {
            User currentUser = (User) session.getAttribute(MessageAttribute.USER);
            String idBooking = request.getParameter(BOOKING_ID);
            Optional<Booking> foundBooking = bookingService.findBookingById(idBooking);
            if (foundBooking.isPresent() && foundBooking.get().getStatus() == Booking.Status.PAYMENT) {
                Booking booking = foundBooking.get();
                double totalPriceBooking = booking.getTotalPrice();
                if (userService.paymentBooking(currentUser, totalPriceBooking)) {
                    bookingService.updateBookingStatus(idBooking, Booking.Status.ACTIVE.getNameStatus());
                    request.setAttribute(MessageAttribute.PAYMENT_MESSAGE, booking.getBookingId());
                    router = new Router(PagePath.NOTIFICATION);
                } else {
                    String locale = (String) session.getAttribute(MessageAttribute.LANGUAGE);
                    String messageWithLocale = CommandUtil.makePartWithLocale(locale, PropertiesMessageKey.PAYMENT_ERROR_MESSAGE);
                    request.setAttribute(MessageAttribute.PAYMENT_ERROR_MESSAGE, messageWithLocale);
                    router = new Router(PagePath.USER_PROFILE);
                }
            } else {
                //request.setAttribute();
                router = new Router(PagePath.NOTIFICATION);
            }
        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router = new Router(PagePath.ERROR_500);
        }
        return router;
    }
}
