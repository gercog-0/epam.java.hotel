package by.epam.project.model.service;

import by.epam.project.entity.Room;
import by.epam.project.exception.ServiceException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RoomService {
    Optional<Room> findByNumber(String roomNumber) throws ServiceException;

    List<Room> sortByParameter(String sortType) throws ServiceException;

    List<Room> findFreeRoomsByParameters(String comfort, String placeAmount, String from, String to)
            throws ServiceException;
}
