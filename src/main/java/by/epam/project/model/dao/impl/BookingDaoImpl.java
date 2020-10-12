package by.epam.project.model.dao.impl;

import by.epam.project.entity.Booking;
import by.epam.project.exception.DaoException;
import by.epam.project.model.dao.BookingDao;

import java.util.List;

public class BookingDaoImpl implements BookingDao {
    @Override
    public boolean add(Booking booking) throws DaoException {
        return false;
    }

    @Override
    public List<Booking> findAll() throws DaoException {
        return null;
    }

    @Override
    public List<Booking> findByStatus(String status) throws DaoException {
        return null;
    }
}
