package by.epam.project.model.dao;

import by.epam.project.entity.Room;
import by.epam.project.exception.DaoException;
import by.epam.project.model.creator.RoomCreator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static by.epam.project.util.RequestParameterName.*;


public interface RoomDao extends BaseDao<Room> {
    Optional<Room> findByNumber(int number) throws DaoException;

    List<Room> findFree(String comfort, int placeAmount, long from, long to) throws DaoException;

    List<Room> findByComfort(String comfort) throws DaoException;

    List<Room> findByPlaceAmount(int placeAmount) throws DaoException;

    List<Room> findByStatus(boolean isActive) throws DaoException;

    boolean activateRoom(int number) throws DaoException;

    boolean inactiveRoom(int number) throws DaoException;
}
