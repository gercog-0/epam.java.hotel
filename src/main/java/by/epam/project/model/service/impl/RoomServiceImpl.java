package by.epam.project.model.service.impl;

import by.epam.project.entity.Room;
import by.epam.project.exception.DaoException;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.dao.impl.RoomDaoImpl;
import by.epam.project.model.service.RoomService;
import by.epam.project.util.DateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomServiceImpl implements RoomService {
    private static final RoomServiceImpl instance = new RoomServiceImpl();

    private RoomServiceImpl() {
    }

    public static RoomServiceImpl getInstance() {
        return instance;
    }

    private static final Logger LOGGER = LogManager.getLogger();


    @Override
    public List<Room> findFreeRoomsByParameters(String comfort, String placeAmount, String from, String to)
            throws ServiceException {
        RoomDaoImpl roomDao = RoomDaoImpl.getInstance();
        List<Room> foundRooms;

        try {
            int places = Integer.parseInt(placeAmount);
            long dateFrom = DateUtil.parseDateToMilliseconds(from);
            long dateTo = DateUtil.parseDateToMilliseconds(to);

            // TODO: 12.10.2020 check date data to valid! 

            foundRooms = roomDao.findFree(comfort, places, dateFrom, dateTo);
        } catch (DaoException | ParseException exp) {
            throw new ServiceException(exp);
        }
        return foundRooms;
    }
}
