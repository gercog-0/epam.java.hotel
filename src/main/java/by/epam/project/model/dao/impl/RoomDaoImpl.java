package by.epam.project.model.dao.impl;

import by.epam.project.entity.Room;
import by.epam.project.exception.DaoException;
import by.epam.project.model.connection.ConnectionPool;
import by.epam.project.model.dao.RoomDao;
import by.epam.project.model.dao.SqlQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class RoomDaoImpl implements RoomDao {
    private static final RoomDaoImpl instance = new RoomDaoImpl();

    private RoomDaoImpl() {
    }

    public static RoomDaoImpl getInstance() {
        return instance;
    }

    @Override
    public Optional<Room> findByNumber(int number) throws DaoException {
        Optional<Room> room = Optional.empty();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_ROOM_BY_NUMBER)) {
            statement.setInt(1, number);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                room = Optional.of(createRoomFromResultSet(resultSet));
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return room;
    }

    @Override
    public List<Room> findFree(String comfort, int placeAmount, long from, long to) throws DaoException {
        List<Room> freeRooms = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_FREE_ROOMS)) {
            statement.setString(1, comfort);
            statement.setInt(2, placeAmount);
            statement.setLong(3, from);
            statement.setLong(4, to);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Room room = createRoomFromResultSet(resultSet);
                freeRooms.add(room);
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return freeRooms;

    }

    @Override
    public List<Room> findByComfort(String comfort) throws DaoException {
        List<Room> allRooms = new ArrayList<>();

        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_ROOMS_BY_COMFORT)) {
            statement.setString(1, comfort);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Room room = createRoomFromResultSet(resultSet);
                allRooms.add(room);
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return allRooms;
    }

    @Override
    public List<Room> findByPlaceAmount(int placeAmount) throws DaoException {
        List<Room> allRooms = new ArrayList<>();

        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_ROOMS_BY_PLACE_AMOUNT)) {
            statement.setInt(1, placeAmount);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Room room = createRoomFromResultSet(resultSet);
                allRooms.add(room);
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return allRooms;
    }

    @Override
    public List<Room> findByStatus(boolean isActive) throws DaoException {
        List<Room> allRooms = new ArrayList<>();

        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_ROOMS_BY_STATUS)) {
            statement.setBoolean(1, isActive);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Room room = createRoomFromResultSet(resultSet);
                allRooms.add(room);
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return allRooms;
    }

    @Override
    public boolean activateRoom(int number) throws DaoException {
        boolean isUpdate;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.SET_ACTIVE_ROOM_STATUS)) {
            statement.setInt(1, number);
            isUpdate = statement.executeUpdate() > 0;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return isUpdate;
    }

    @Override
    public boolean inactiveRoom(int number) throws DaoException {
        boolean isUpdate;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.SET_INACTIVE_ROOM_STATUS)) {
            statement.setInt(1, number);
            isUpdate = statement.executeUpdate() > 0;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return isUpdate;
    }

    @Override
    public boolean add(Room room) throws DaoException {
        boolean update;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.ADD_ROOM)) {
            statement.setInt(1, room.getNumber());
            statement.setString(2, room.getComfort().getName());
            statement.setDouble(3, room.getPrice());
            statement.setInt(4, room.getPlaceAmount());
            statement.setBoolean(5, room.isActive());

            update = statement.executeUpdate() > 0;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return update;
    }

    @Override
    public List<Room> findAll() throws DaoException {
        List<Room> allRooms = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_ALL_ROOMS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Room room = createRoomFromResultSet(resultSet);
                allRooms.add(room);
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return allRooms;
    }
}
