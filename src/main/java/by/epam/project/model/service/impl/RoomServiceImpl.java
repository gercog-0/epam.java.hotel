package by.epam.project.model.service.impl;

import by.epam.project.entity.Room;
import by.epam.project.exception.DaoException;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.dao.impl.RoomDaoImpl;
import by.epam.project.model.service.RoomService;
import by.epam.project.util.DateUtil;
import by.epam.project.util.comparator.RoomComparator;
import by.epam.project.validator.RoomValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

import static by.epam.project.util.RequestParameterName.*;

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
        try {
            if (!RoomValidator.isRoomNumberCorrect(roomNumber)) {
                return Optional.empty();
            }
            int number = Integer.parseInt(roomNumber);
            return roomDao.findByNumber(number);
        } catch (DaoException exp) {
            throw new ServiceException();
        }
    }

    public Map<String, String> defineRoomData(String roomNumber, String roomComfort,
                                              String placeAmount, String roomPrice) throws ServiceException {
        RoomDaoImpl roomDao = RoomDaoImpl.getInstance();
        Map<String, String> roomData = RoomValidator.validateParameters(roomComfort,
                roomPrice, placeAmount, roomNumber);
        try {
            if (RoomValidator.isRoomNumberCorrect(roomNumber)) {
                int number = Integer.parseInt(roomNumber);
                roomData.put(ROOM_NUMBER_UNIQUE, roomDao.findByNumber(number).isEmpty() ? roomNumber : NOT_UNIQUE);
            }
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return roomData;
    }

    @Override
    public List<Room> sortByParameter(List<Room> freeRooms, String sortType) throws ServiceException {
        try {
            Comparator<Room> currentComparator = RoomComparator.valueOf(sortType.toUpperCase()).getComparator();
            List<Room> sortedList = freeRooms.stream().sorted(currentComparator).collect(Collectors.toList());
            return sortedList;
        } catch (IllegalArgumentException exp) {
            throw new ServiceException("Unknown type of comparator.");
        }
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

    @Override
    public List<Room> findAllRooms() throws ServiceException {
        RoomDaoImpl roomDao = RoomDaoImpl.getInstance();
        List<Room> roomsList;

        try {
            roomsList = roomDao.findAll();
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return roomsList;
    }

    @Override
    public boolean addRoom(Room room) throws ServiceException {
        RoomDaoImpl roomDao = RoomDaoImpl.getInstance();
        boolean isRoomAdded;
        try {
            isRoomAdded = roomDao.add(room);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return isRoomAdded;
    }

    @Override
    public boolean activateRoom(String number) throws ServiceException {
        RoomDaoImpl roomDao = RoomDaoImpl.getInstance();
        try {
            int roomNumber = Integer.parseInt(number);
            return roomDao.activateRoom(roomNumber);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
    }

    @Override
    public boolean inactivateRoom(String number) throws ServiceException {
        RoomDaoImpl roomDao = RoomDaoImpl.getInstance();
        try {
            int roomNumber = Integer.parseInt(number);
            return roomDao.inactiveRoom(roomNumber);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
    }
}
