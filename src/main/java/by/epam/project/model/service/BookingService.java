package by.epam.project.model.service;

import by.epam.project.exception.ServiceException;
import by.epam.project.model.entity.Booking;
import by.epam.project.model.entity.Room;
import by.epam.project.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Booking> findBookingsByUserId(int id) throws ServiceException;

    List<Booking> findBookingsByStatus(String status) throws ServiceException;

    List<Booking> findAllBookings() throws ServiceException;

    List<Booking> sortByParameter(List<Booking> bookings, String sortType) throws ServiceException;

    Optional<Booking> findBookingById(String id) throws ServiceException;

    boolean makeBooking(String arrivalDateString, String departureDateString, User user, Room room) throws ServiceException;

    boolean updateBookingStatus(String id, String status) throws ServiceException;
}
