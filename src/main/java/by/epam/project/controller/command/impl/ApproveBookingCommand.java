package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.PagePath;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.service.impl.BookingServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.project.util.RequestParameterName.*;

public class ApproveBookingCommand implements Command {
    private final BookingServiceImpl bookingService = BookingServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
       // HttpSession session = request.getSession();
       // Router router;
//
       // try {
       //     String idBooking = request.getParameter(BOOKING_ID);
       // } catch (ServiceException exp) {
       //     LOGGER.error(exp);
       //     router = new Router(PagePath.ERROR_500);
       // }
        return null;
    }
}
