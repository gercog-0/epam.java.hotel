package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.PagePath;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.entity.Room;
import by.epam.project.model.service.impl.RoomServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.project.util.RequestParameterName.*;

/**
 * Sort rooms command.
 * The team is responsible for sorting rooms.
 */
public class SortRoomsCommand implements Command {
    private RoomServiceImpl roomService = RoomServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Router router;

        try {
            String currentPage = (String) session.getAttribute(CURRENT_PAGE);
            String sortType = request.getParameter(ROOM_TYPE_SORT);
            List<Room> currentRoomsList;
            String attributeName;
            if (currentPage.equals(PagePath.BOOKING)) {
                currentRoomsList = (List<Room>) session.getAttribute(PAGINATION_ROOMS);
                attributeName = PAGINATION_ROOMS;
            } else {
                currentRoomsList = (List<Room>) session.getAttribute(ROOMS);
                attributeName = ROOMS;
            }
            List<Room> sortedRoomsList = roomService.sortByParameter(currentRoomsList, sortType);
            session.setAttribute(attributeName, sortedRoomsList);
            router = new Router(currentPage);
        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router = new Router(PagePath.ERROR_500);
        }
        return router;
    }
}
