package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.*;
import by.epam.project.controller.command.impl.util.CommandUtil;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.entity.Room;
import by.epam.project.model.service.impl.RoomServiceImpl;
import by.epam.project.util.PaginationUtil;
import by.epam.project.validator.DateValidator;
import by.epam.project.validator.RoomValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import static by.epam.project.util.RequestParameterName.*;

/**
 * Filter rooms command.
 * This command processes the selection criteria for finding
 * available hotel rooms for booking.
 */
public class FilterRoomsCommand implements Command {
    private RoomServiceImpl roomService = RoomServiceImpl.getInstance();
    private static final int DEFAULT_SPLIT_NUMBER = 10;
    private static final int DEFAULT_PAGE_NUMBER = 1;

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String currentPageList = request.getParameter(ROOM_LIST_PAGE);
        if (currentPageList == null) {
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
                    int maxQuantityPagesOfList = PaginationUtil.calculateTotalPages(foundRooms, DEFAULT_SPLIT_NUMBER);
                    session.setAttribute(MessageAttribute.MAX_QUANTITY_PAGES, maxQuantityPagesOfList);
                    List<Room> definedCrossSectionListByPage = PaginationUtil.takeSplitListByPage(foundRooms,
                            DEFAULT_SPLIT_NUMBER, DEFAULT_PAGE_NUMBER);
                    session.setAttribute(ROOMS, foundRooms);
                    session.setAttribute(PAGINATION_ROOMS, definedCrossSectionListByPage);
                    session.setAttribute(BOOKING_DATE_FROM, arrivalDateString);
                    session.setAttribute(BOOKING_DATE_TO, departureDateString);
                } else {
                    String locale = (String) session.getAttribute(MessageAttribute.LANGUAGE);
                    String messageWithLocale = CommandUtil.makePartWithLocale(locale,
                            PropertiesMessageKey.FILTER_ROOMS_INCORRECT_DATA);
                    request.setAttribute(MessageAttribute.FILTER_ROOMS_ERROR_MESSAGE, messageWithLocale);
                }
                return new Router(PagePath.BOOKING);
            } catch (ServiceException exp) {
                LOGGER.error(exp);
                return new Router(PagePath.ERROR_500);
            }
        } else {
            int currentPage = Integer.parseInt(currentPageList);
            List<Room> currentFreeRoomsList = (List<Room>) session.getAttribute(ROOMS);
            List<Room> definedCrossSectionListByPage = PaginationUtil.takeSplitListByPage(currentFreeRoomsList,
                    DEFAULT_SPLIT_NUMBER, currentPage);
            session.setAttribute(PAGINATION_ROOMS, definedCrossSectionListByPage);
            return new Router(PagePath.BOOKING);
        }
    }
}
