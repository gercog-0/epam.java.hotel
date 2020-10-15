package by.epam.project.model.service;

import by.epam.project.entity.Room;
import by.epam.project.entity.User;
import by.epam.project.exception.ServiceException;

public interface BookingService {
    boolean makeBooking(String arrivalDateString, String departureDateString,
                        User user, Room room) throws ServiceException;
}
