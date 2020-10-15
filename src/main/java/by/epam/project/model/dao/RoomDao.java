package by.epam.project.model.dao;

import by.epam.project.entity.Room;
import by.epam.project.exception.DaoException;
import by.epam.project.model.creator.RoomCreator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static by.epam.project.util.RequestParameterName.*;


public interface RoomDao extends BaseDaoSql<Room> {
    Optional<Room> findByNumber(int number) throws DaoException;

    List<Room> findFree(String comfort, int placeAmount, long from, long to) throws DaoException;

    List<Room> findByComfort(String comfort) throws DaoException;

    List<Room> findByPlaceAmount(int placeAmount) throws DaoException;

    List<Room> findByStatus(boolean isActive) throws DaoException;

    boolean activateRoom(int number) throws DaoException;

    boolean inactiveRoom(int number) throws DaoException;

    default Room createRoomFromResultSet(ResultSet resultSet) throws DaoException {
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
}
