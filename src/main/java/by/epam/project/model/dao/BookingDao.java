package by.epam.project.model.dao;

import by.epam.project.model.entity.Booking;
import by.epam.project.exception.DaoException;

import java.util.List;
import java.util.Optional;


public interface BookingDao extends BaseDao<Booking> {
    List<Booking> findByStatus(String status) throws DaoException;

    List<Booking> findAllByIdUser(int userId) throws DaoException;

    Optional<Booking> findById(int id) throws DaoException;

    boolean updateStatusById(int id, String status) throws DaoException;
}
