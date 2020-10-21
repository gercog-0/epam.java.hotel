package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.MessageAttribute;
import by.epam.project.controller.command.PagePath;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.creator.RoomCreator;
import by.epam.project.model.entity.Room;
import by.epam.project.model.service.impl.RoomServiceImpl;
import by.epam.project.validator.RoomValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Map;

import static by.epam.project.util.RequestParameterName.*;

public class AddRoomCommand implements Command {
    private RoomServiceImpl roomService = RoomServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        RoomCreator roomCreator = RoomCreator.getInstance();
        HttpSession session = request.getSession();
        Router router;

        try {
            String roomNumber = request.getParameter(ROOM_NUMBER);
            String roomComfort = request.getParameter(ROOM_COMFORT);
            String roomPlaces = request.getParameter(ROOM_PLACE_AMOUNT);
            String roomPrice = request.getParameter(ROOM_PRICE);

            Map<String, String> roomData = roomService.defineRoomData(roomNumber, roomComfort, roomPlaces, roomPrice);
            if (RoomValidator.defineIncorrectValues(roomData)) {
                Room newRoom = roomCreator.createRoom(roomNumber, roomComfort, roomPlaces, roomPrice);
                roomService.addRoom(newRoom);
                request.setAttribute(MessageAttribute.ADD_ROOM_NUMBER, roomNumber);
                router = new Router(PagePath.NOTIFICATION);
            } else {
                request.setAttribute(MessageAttribute.ROOM_DATA, roomData);
                router = new Router(PagePath.ROOMS_ADMIN);
            }
        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router = new Router(PagePath.ERROR_500);
        }
        return router;
    }
}
