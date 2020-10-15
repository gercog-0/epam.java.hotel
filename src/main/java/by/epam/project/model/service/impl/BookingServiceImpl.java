package by.epam.project.model.service.impl;

import by.epam.project.entity.Booking;
import by.epam.project.entity.Room;
import by.epam.project.entity.User;
import by.epam.project.exception.DaoException;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.creator.BookingCreator;
import by.epam.project.model.dao.impl.BookingDaoImpl;
import by.epam.project.model.service.BookingService;
import by.epam.project.util.DateUtil;

import java.util.Date;
import java.util.Optional;

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
}
