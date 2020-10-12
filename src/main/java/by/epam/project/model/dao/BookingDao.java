package by.epam.project.model.dao;

import by.epam.project.entity.Booking;
import by.epam.project.exception.DaoException;

import java.util.List;

public interface BookingDao extends BaseDaoSql<Booking>{
    List<Booking> findByStatus(String status) throws DaoException;

}
