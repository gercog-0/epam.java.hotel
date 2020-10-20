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

public interface BookingDao extends BaseDao<Booking> {
    List<Booking> findByStatus(String status) throws DaoException;

    List<Booking> findAllByIdUser(int userId) throws DaoException;

    Optional<Booking> findById(int id) throws DaoException;

    boolean updateStatusById(int id, String status) throws DaoException;
}
