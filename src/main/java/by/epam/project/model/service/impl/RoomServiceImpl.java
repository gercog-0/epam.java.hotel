package by.epam.project.model.service.impl;

import by.epam.project.comparator.RoomComparator;
import by.epam.project.controller.command.CommandType;
import by.epam.project.entity.Room;
import by.epam.project.exception.DaoException;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.dao.impl.RoomDaoImpl;
import by.epam.project.model.service.RoomService;
import by.epam.project.util.DateUtil;
import by.epam.project.validator.impl.RoomValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.util.*;

public class RoomServiceImpl implements RoomService {
    private static final RoomServiceImpl instance = new RoomServiceImpl();

    private RoomServiceImpl() {
    }

    public static RoomServiceImpl getInstance() {
        return instance;
    }

    private static final Logger LOGGER = LogManager.getLogger();


    @Override
    public Optional<Room> findByNumber(String roomNumber) throws ServiceException {
        RoomDaoImpl roomDao = RoomDaoImpl.getInstance();
        RoomValidatorImpl roomValidator = RoomValidatorImpl.getInstance();

        try {
            if (!roomValidator.isRoomNumberCorrect(roomNumber)) {
                return Optional.empty();
            }
            int number = Integer.parseInt(roomNumber);
            return roomDao.findByNumber(number);
        } catch (DaoException exp) {
            throw new ServiceException();
        }
    }

    @Override
    public List<Room> sortByParameter(String sortType) throws ServiceException {
        RoomDaoImpl roomDao = RoomDaoImpl.getInstance();
        Comparator<Room> currentComparator = RoomComparator.valueOf(sortType.toUpperCase()).getComparator();
        //try{
        //    List<Room> foundFreeRooms = roomDao.
        //}
        return null;
    }

    @Override
    public List<Room> findFreeRoomsByParameters(String comfort, String placeAmount,
                                                String dateFromString, String dateToString)
            throws ServiceException {
        RoomDaoImpl roomDao = RoomDaoImpl.getInstance();
        List<Room> foundRooms;

        try {
            int places = Integer.parseInt(placeAmount);
            long dateFrom = DateUtil.parseDateStringToMilliseconds(dateFromString);
            long dateTo = DateUtil.parseDateStringToMilliseconds(dateToString);

            foundRooms = roomDao.findFree(comfort.toLowerCase(), places, dateFrom, dateTo);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return foundRooms;
    }


}
