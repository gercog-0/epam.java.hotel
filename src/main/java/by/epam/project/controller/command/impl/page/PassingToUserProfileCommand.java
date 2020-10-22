package by.epam.project.controller.command.impl.page;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.MessageAttribute;
import by.epam.project.controller.command.PagePath;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.entity.Booking;
import by.epam.project.model.entity.User;
import by.epam.project.model.service.impl.BookingServiceImpl;
import by.epam.project.model.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

import static by.epam.project.util.RequestParameterName.*;

/**
 * The type Passing to user profile command.
 */
public class PassingToUserProfileCommand implements Command {
    private BookingServiceImpl bookingService = BookingServiceImpl.getInstance();
    private UserServiceImpl userService = UserServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Router router;
        try {
            User currentUser = (User) session.getAttribute(MessageAttribute.USER);
            int userId = currentUser.getId();
            Optional<User> updatedUserOptional = userService.findUserById(userId);
            if (updatedUserOptional.isPresent()) {
                User updatedUser = updatedUserOptional.get();
                session.setAttribute(MessageAttribute.USER, updatedUser);
                List<Booking> personalBookings = bookingService.findBookingsByUserId(userId);
                session.setAttribute(MessageAttribute.PERSONAL_BOOKINGS, personalBookings);
                session.setAttribute(USER_LOGIN, updatedUser.getLogin());
                session.setAttribute(USER_BALANCE, updatedUser.getBalance());
                router = new Router(PagePath.USER_PROFILE);
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
