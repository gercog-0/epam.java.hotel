package by.epam.project.controller.command.impl.page;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.PagePath;
import by.epam.project.model.entity.Room;
import by.epam.project.model.entity.User;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.service.impl.RoomServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.project.util.RequestParameterName.ROOMS;

/**
 * The type Passing to rooms admin command.
 */
public class PassingToRoomsAdminCommand implements Command {

    private RoomServiceImpl roomService = RoomServiceImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Router router;

        try {
            List<Room> allRooms = roomService.findAllRooms();
            session.setAttribute(ROOMS, allRooms);
            router = new Router(PagePath.ROOMS_ADMIN);
        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router = new Router(PagePath.ERROR_500);
        }
        return router;
    }
}
