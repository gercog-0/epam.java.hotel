package by.epam.project.model.service;

import by.epam.project.entity.Room;
import by.epam.project.exception.ServiceException;

import java.util.Date;
import java.util.List;

public interface RoomService {
    List<Room> findFreeRoomsByParameters(String comfort, String placeAmount, String from, String to)
            throws ServiceException;
}
