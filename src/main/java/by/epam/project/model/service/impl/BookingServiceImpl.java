package by.epam.project.model.service.impl;

import by.epam.project.exception.DaoException;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.creator.BookingCreator;
import by.epam.project.model.dao.impl.BookingDaoImpl;
import by.epam.project.model.entity.Booking;
import by.epam.project.model.entity.Room;
import by.epam.project.model.entity.User;
import by.epam.project.model.service.BookingService;
import by.epam.project.util.DateUtil;
import by.epam.project.util.comparator.BookingComparator;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {
    private static BookingServiceImpl instance = new BookingServiceImpl();

    private BookingServiceImpl() {
    }

    public static BookingServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean makeBooking(String arrivalDateString, String departureDateString,
                               User user, Room room) throws ServiceException {
        BookingDaoImpl bookingDao = BookingDaoImpl.getInstance();
        BookingCreator creator = BookingCreator.getInstance();
        boolean isMade = false;

        Optional<Date> arrivalDateOptional = DateUtil.parseStringToDateFormat(arrivalDateString);
        Optional<Date> departureDateOptional = DateUtil.parseStringToDateFormat(departureDateString);
        try {
            if (arrivalDateOptional.isPresent() && departureDateOptional.isPresent()) {
                Date arrivalDate = arrivalDateOptional.get();
                Date departureDate = departureDateOptional.get();
                Booking booking = creator.createBooking(user, room, arrivalDate, departureDate, room.getPrice());
                isMade = bookingDao.add(booking);
            }
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return isMade;
    }

    @Override
    public List<Booking> findBookingsByUserId(int id) throws ServiceException {
        BookingDaoImpl bookingDao = BookingDaoImpl.getInstance();
        List<Booking> bookings;
        try {
            bookings = bookingDao.findAllByIdUser(id);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return bookings;
    }

    @Override
    public List<Booking> findBookingsByStatus(String status) throws ServiceException {
        BookingDaoImpl bookingDao = BookingDaoImpl.getInstance();
        List<Booking> bookings;
        try {
            bookings = bookingDao.findByStatus(status);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return bookings;
    }

    @Override
    public List<Booking> findAllBookings() throws ServiceException {
        BookingDaoImpl bookingDao = BookingDaoImpl.getInstance();
        List<Booking> bookings;
        try {
            bookings = bookingDao.findAll();
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return bookings;
    }

    @Override
    public List<Booking> sortByParameter(List<Booking> bookings, String sortType) throws ServiceException {
        try {
            Comparator<Booking> currentComparator = BookingComparator.valueOf(sortType.toUpperCase()).getComparator();
            List<Booking> sortedList = bookings.stream().sorted(currentComparator).collect(Collectors.toList());
            return sortedList;
        } catch (IllegalArgumentException exp) {
            throw new ServiceException("Unknown type of comparator.");
        }
    }

    @Override
    public Optional<Booking> findBookingById(String id) throws ServiceException {
        BookingDaoImpl bookingDao = BookingDaoImpl.getInstance();
        Optional<Booking> foundBooking;
        try {
            int bookingId = Integer.parseInt(id);
            foundBooking = bookingDao.findById(bookingId);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return foundBooking;
    }

    @Override
    public boolean updateBookingStatus(String id, String status) throws ServiceException {
        BookingDaoImpl bookingDao = BookingDaoImpl.getInstance();
        try {
            int bookingId = Integer.parseInt(id);
            Optional<Booking.Status> optionalStatus = Booking.Status.getStatusByValue(status);
            if (optionalStatus.isPresent()) {
                return bookingDao.updateStatusById(bookingId, status);
            }
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return false;
    }
}
