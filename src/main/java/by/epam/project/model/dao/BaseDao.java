package by.epam.project.model.dao;

import by.epam.project.model.entity.Booking;
import by.epam.project.model.entity.Entity;
import by.epam.project.exception.DaoException;
import by.epam.project.model.creator.BookingCreator;
import by.epam.project.model.creator.RoomCreator;
import by.epam.project.model.creator.UserCreator;
import by.epam.project.model.entity.Room;
import by.epam.project.model.entity.User;
import by.epam.project.util.DateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static by.epam.project.util.RequestParameterName.*;
import static by.epam.project.util.RequestParameterName.USER_ROLE_ID;

/**
 * The interface Base dao.
 *
 * @param <T> the type parameter
 */
public interface BaseDao<T extends Entity> {
    /**
     * The constant logger.
     */
    Logger logger = LogManager.getLogger();

    /**
     * Add boolean.
     *
     * @param t the t
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean add(T t) throws DaoException;

    /**
     * Find all list.
     *
     * @return the list
     * @throws DaoException the dao exception
     */
    List<T> findAll() throws DaoException;

    /**
     * Close statement.
     *
     * @param statement the statement
     */
    default void closeStatement(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException exp) {
                logger.error("Closing statement error", exp);
            }
        }
    }

    /**
     * Close result set.
     *
     * @param resultSet the result set
     */
    default void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException exp) {
                logger.error("Closing resultSet error", exp);
            }
        }
    }

    /**
     * Create user from result set user.
     *
     * @param resultSet the result set
     * @return the user
     * @throws DaoException the dao exception
     */
    default User createUserFromResultSet(ResultSet resultSet) throws DaoException {
        UserCreator creator = UserCreator.getInstance();

        try {
            int userId = resultSet.getInt(USER_ID);
            String userLogin = resultSet.getString(USER_LOGIN);
            String userEmail = resultSet.getString(USER_EMAIL);
            String userName = resultSet.getString(USER_NAME);
            String userSurname = resultSet.getString(USER_SURNAME);
            String userPhone = resultSet.getString(USER_PHONE);
            double userBalance = resultSet.getDouble(USER_BALANCE);
            boolean userIsBanned = resultSet.getBoolean(USER_IS_BANNED);
            boolean userIsActivated = resultSet.getBoolean(USER_IS_ACTIVATED);
            int userRoleId = resultSet.getInt(USER_ROLE_ID);

            User createdUser = creator.createUser(userId, userLogin, userEmail, userName,
                    userSurname, userPhone, userBalance, userIsBanned, userIsActivated, userRoleId);
            return createdUser;
        } catch (SQLException exp) {
            throw new DaoException("Error while creating user from resultSet", exp);
        }
    }

    /**
     * Create room from result set room.
     *
     * @param resultSet the result set
     * @return the room
     * @throws DaoException the dao exception
     */
    default   Room createRoomFromResultSet(ResultSet resultSet) throws DaoException {
        RoomCreator creator = RoomCreator.getInstance();

        try {
            int roomId = resultSet.getInt(ROOM_ID);
            int roomNumber = resultSet.getInt(ROOM_NUMBER);
            String roomComfort = resultSet.getString(ROOM_COMFORT);
            double roomPrice = resultSet.getDouble(ROOM_PRICE);
            int roomPlaceAmount = resultSet.getInt(ROOM_PLACE_AMOUNT);
            boolean roomIsActive = resultSet.getBoolean(ROOM_IS_ACTIVE);


            Optional<Room.Comfort> comfortOptional = Room.Comfort.getComfortTypeByValue(roomComfort);
            Room.Comfort comfortType = comfortOptional.orElseThrow(DaoException::new);

            Room createdRoom = creator.createRoom(roomId, roomNumber, comfortType,
                    roomPrice, roomPlaceAmount, roomIsActive);
            return createdRoom;
        } catch (SQLException exp) {
            throw new DaoException("Error while creating room from resultSet", exp);
        }
    }

    /**
     * Create booking from result set booking.
     *
     * @param resultSet the result set
     * @return the booking
     * @throws DaoException the dao exception
     */
    default Booking createBookingFromResultSet(ResultSet resultSet) throws DaoException {
        BookingCreator creator = BookingCreator.getInstance();

        try {
            int bookingId = resultSet.getInt(BOOKING_ID);
            long arrivalDateLong = resultSet.getLong(BOOKING_ARRIVAL_DATE);
            long departureDateLong = resultSet.getLong(BOOKING_DEPARTURE_DATE);
            String bookingStatus = resultSet.getString(BOOKING_STATUS);
            User user = createUserFromResultSet(resultSet);
            Room room = createRoomFromResultSet(resultSet);
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
