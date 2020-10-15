package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.MessageAttribute;
import by.epam.project.controller.command.PagePath;
import by.epam.project.entity.Room;
import by.epam.project.entity.User;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.service.impl.BookingServiceImpl;
import by.epam.project.model.service.impl.RoomServiceImpl;
import by.epam.project.util.RequestParameterName;
import by.epam.project.validator.impl.RoomValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

import static by.epam.project.util.RequestParameterName.*;

public class BookingCommand implements Command {
    private final BookingServiceImpl bookingService = BookingServiceImpl.getInstance();
    private final RoomServiceImpl roomService = RoomServiceImpl.getInstance();
    private final RoomValidatorImpl roomValidator = RoomValidatorImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Router router;

        try {
            String dateFrom = (String) session.getAttribute(BOOKING_DATE_FROM);
            String dateTo = (String) session.getAttribute(BOOKING_DATE_TO);
            User currentUser = (User) session.getAttribute(MessageAttribute.USER);
            String roomNumber = request.getParameter(ROOM_NUMBER);
            Optional<Room> foundRoom = roomService.findByNumber(roomNumber);
            if (foundRoom.isPresent()) {
                Room room = foundRoom.get();
                bookingService.makeBooking(dateFrom, dateTo, currentUser, room);
                // TODO: 14.10.2020 mail sms
                session.removeAttribute(BOOKING_DATE_FROM);
                session.removeAttribute(BOOKING_DATE_TO);
                // TODO: 14.10.2020
                router = new Router(PagePath.HOME);
            } else {
                // TODO: 14.10.2020
                router = new Router(PagePath.ERROR_404);
            }
        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router = new Router(PagePath.ERROR_500);
        }
        return router;
    }
}
