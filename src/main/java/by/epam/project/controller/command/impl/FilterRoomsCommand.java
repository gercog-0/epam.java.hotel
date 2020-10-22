package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.*;
import by.epam.project.controller.command.impl.util.CommandUtil;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.entity.Room;
import by.epam.project.model.service.impl.RoomServiceImpl;
import by.epam.project.validator.DateValidator;
import by.epam.project.validator.RoomValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import static by.epam.project.util.RequestParameterName.*;

/**
 * The type Filter rooms command.
 */
public class FilterRoomsCommand implements Command {
    private RoomServiceImpl roomService = RoomServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router;
        HttpSession session = request.getSession();

        try {
            String placeAmount = request.getParameter(PLACE_AMOUNT_ROOM);
            String comfort = request.getParameter(COMFORT_ROOM);
            String arrivalDateString = request.getParameter(BOOKING_DATE_FROM);
            String departureDateString = request.getParameter(BOOKING_DATE_TO);

            if (RoomValidator.isComfortTypeCorrect(comfort)
                    && RoomValidator.isPlaceAmountCorrect(placeAmount)
                    && DateValidator.checkDate(arrivalDateString, departureDateString)) {
                List<Room> foundRooms = roomService.findFreeRoomsByParameters(comfort,
                        placeAmount, arrivalDateString, departureDateString);
                session.setAttribute(ROOMS, foundRooms);
                session.setAttribute(BOOKING_DATE_FROM, arrivalDateString);
                session.setAttribute(BOOKING_DATE_TO, departureDateString);

                String currentPage = (String) session.getAttribute(CURRENT_PAGE);
                router = new Router(currentPage);
            } else {
                String locale = (String) session.getAttribute(MessageAttribute.LANGUAGE);
                String messageWithLocale = CommandUtil.makePartWithLocale(locale,
                        PropertiesMessageKey.FILTER_ROOMS_INCORRECT_DATA);
                request.setAttribute(MessageAttribute.FILTER_ROOMS_ERROR_MESSAGE, messageWithLocale);
                router = new Router(PagePath.BOOKING);
            }
        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router = new Router(PagePath.ERROR_500);
        }
        return router;
    }
}
