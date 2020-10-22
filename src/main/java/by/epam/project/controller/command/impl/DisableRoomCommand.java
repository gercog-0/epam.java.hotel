package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.MessageAttribute;
import by.epam.project.controller.command.PagePath;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.service.impl.RoomServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.epam.project.util.RequestParameterName.ROOM_NUMBER;

/**
 * The type Disable room command.
 */
public class DisableRoomCommand implements Command {
    private RoomServiceImpl roomService = RoomServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router;
        String roomNumber = request.getParameter(ROOM_NUMBER);
        try {
            roomService.inactivateRoom(roomNumber);
            request.setAttribute(MessageAttribute.DISABLE_ROOM_NUMBER, roomNumber);
            router = new Router(PagePath.NOTIFICATION);
        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router = new Router(PagePath.ERROR_500);
        }
        return router;
    }

}
