package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.PagePath;
import by.epam.project.entity.Room;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.service.impl.RoomServiceImpl;
import by.epam.project.validator.impl.RoomValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static by.epam.project.util.RequestParameter.*;

public class AdvanceBookingCommand implements Command {
    private final RoomServiceImpl roomService = RoomServiceImpl.getInstance();
    private final RoomValidatorImpl roomValidator = RoomValidatorImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router;

        try {
            String placeAmount = request.getParameter(PLACE_AMOUNT_ROOM);
            String comfort = request.getParameter(COMFORT_ROOM);
            String arrivalDateString = request.getParameter(BOOKING_DATE_FROM);
            String departureDateString = request.getParameter(BOOKING_DATE_TO);

            if (roomValidator.isComfortTypeCorrect(comfort)
                    && roomValidator.isPlaceAmountCorrect(placeAmount)) {
                List<Room> foundRooms = roomService.findFreeRoomsByParameters(comfort,
                        placeAmount, arrivalDateString, departureDateString);
                request.setAttribute(FREE_ROOMS, foundRooms);
                // TODO: 12.10.2020 redirect to this page with new form
                router = new Router(PagePath.ROOMS);
            } else {
                router = new Router(PagePath.ADVANCE_BOOKING);
            }

        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router = new Router(PagePath.ERROR_505);
        }
        return router;
    }
}
