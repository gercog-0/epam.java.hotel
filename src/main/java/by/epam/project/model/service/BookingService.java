package by.epam.project.model.service;

import by.epam.project.exception.ServiceException;
import by.epam.project.model.entity.Booking;
import by.epam.project.model.entity.Room;
import by.epam.project.model.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * The interface Booking service.
 */
public interface BookingService {
    /**
     * Find bookings by user id list.
     *
     * @param id the id
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Booking> findBookingsByUserId(int id) throws ServiceException;

    /**
     * Find bookings by status list.
     *
     * @param status the status
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Booking> findBookingsByStatus(String status) throws ServiceException;

    /**
     * Find all bookings list.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Booking> findAllBookings() throws ServiceException;

    /**
     * Sort by parameter list.
     *
     * @param bookings the bookings
     * @param sortType the sort type
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Booking> sortByParameter(List<Booking> bookings, String sortType) throws ServiceException;

    /**
     * Find booking by id optional.
     *
     * @param id the id
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<Booking> findBookingById(String id) throws ServiceException;

    /**
     * Make booking boolean.
     *
     * @param arrivalDateString   the arrival date string
     * @param departureDateString the departure date string
     * @param user                the user
     * @param room                the room
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean makeBooking(String arrivalDateString, String departureDateString, User user, Room room) throws ServiceException;

    /**
     * Update booking status boolean.
     *
     * @param id     the id
     * @param status the status
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean updateBookingStatus(String id, String status) throws ServiceException;
}
