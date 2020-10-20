package by.epam.project.model.dao.impl;

import by.epam.project.entity.Booking;
import by.epam.project.entity.Room;
import by.epam.project.exception.DaoException;
import by.epam.project.model.connection.ConnectionPool;
import by.epam.project.model.dao.BookingDao;
import by.epam.project.model.dao.SqlQuery;
import by.epam.project.util.DateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingDaoImpl implements BookingDao {
    private static final BookingDaoImpl instance = new BookingDaoImpl();

    private BookingDaoImpl() {
    }

    public static BookingDaoImpl getInstance() {
        return instance;
    }


    @Override
    public boolean add(Booking booking) throws DaoException {
        boolean update;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.ADD_BOOKING)) {
            statement.setLong(1, DateUtil.parseDateToMilliseconds(booking.getArrivalDate()));
            statement.setLong(2, DateUtil.parseDateToMilliseconds(booking.getDepartureDate()));
            statement.setString(3, booking.getStatus().getNameStatus());
            statement.setInt(4, booking.getUser().getId());
            statement.setInt(5, booking.getRoom().getRoomId());
            statement.setDouble(6, booking.getTotalPrice());

            update = statement.executeUpdate() > 0;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return update;
    }


    @Override
    public Optional<Booking> findById(int id) throws DaoException {
        Optional<Booking> booking = Optional.empty();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_BOOKING_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                booking = Optional.of(createBookingFromResultSet(resultSet));
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return booking;
    }

    @Override
    public boolean updateStatusById(int id, String status) throws DaoException {
        boolean isUpdate;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.UPDATE_STATUS_BOOKING)) {
            statement.setString(1, status);
            statement.setInt(2, id);
            isUpdate = statement.executeUpdate() > 0;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return isUpdate;
    }

    @Override
    public List<Booking> findAllByIdUser(int userId) throws DaoException {
        List<Booking> bookings = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_ALL_BOOKINGS_BY_USER_ID)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Booking booking = createBookingFromResultSet(resultSet);
                bookings.add(booking);
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return bookings;
    }


    @Override
    public List<Booking> findAll() throws DaoException {
        List<Booking> bookings = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_ALL_BOOKINGS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Booking booking = createBookingFromResultSet(resultSet);
                bookings.add(booking);
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return bookings;
    }


    @Override
    public List<Booking> findByStatus(String status) throws DaoException {
        List<Booking> bookings = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_ALL_BOOKINGS_BY_STATUS)) {
            statement.setString(1, status);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Booking booking = createBookingFromResultSet(resultSet);
                bookings.add(booking);
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return bookings;
    }
}
