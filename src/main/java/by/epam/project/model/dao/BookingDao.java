package by.epam.project.model.dao;

import by.epam.project.entity.Booking;
import by.epam.project.entity.Room;
import by.epam.project.entity.User;
import by.epam.project.exception.DaoException;
import by.epam.project.model.creator.BookingCreator;
import by.epam.project.model.creator.RoomCreator;
import by.epam.project.util.DateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static by.epam.project.util.RequestParameterName.*;

public interface BookingDao extends BaseDaoSql<Booking> {
    List<Booking> findByStatus(String status) throws DaoException;

    Optional<Booking> findById(int id) throws DaoException;

    default Booking createBookingFromResultSet(ResultSet resultSet) throws DaoException {
        BookingCreator creator = BookingCreator.getInstance();

        try {
            int bookingId = resultSet.getInt(BOOKING_ID);
            long arrivalDateLong = resultSet.getLong(BOOKING_ARRIVAL_DATE);
            long departureDateLong = resultSet.getLong(BOOKING_DEPARTURE_DATE);
            String bookingStatus = resultSet.getString(BOOKING_STATUS);
            User user = null;
            Room room = null;
            double totalPrice = resultSet.getDouble(BOOKING_TOTAL_PRICE);

            Optional<Booking.Status> statusOptional = Booking.Status.getStatusByValue(bookingStatus);
            Booking.Status status = statusOptional.orElseThrow(DaoException::new);
            Date arrivalDate = DateUtil.parseMillisecondsToDate(arrivalDateLong);
            Date departureDate = DateUtil.parseMillisecondsToDate(departureDateLong);

            Booking createdBooking = creator.createBooking(bookingId, user, room, arrivalDate,
                    departureDate, status, totalPrice);

            return createdBooking;
        } catch (SQLException exp) {
            throw new DaoException("Error while creating booking from resultSet", exp);
        }
    }

}
