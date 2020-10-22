package by.epam.project.model.dao;

import by.epam.project.model.entity.Booking;
import by.epam.project.exception.DaoException;

import java.util.List;
import java.util.Optional;


/**
 * The interface Booking dao.
 */
public interface BookingDao extends BaseDao<Booking> {
    /**
     * Find by status list.
     *
     * @param status the status
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Booking> findByStatus(String status) throws DaoException;

    /**
     * Find all by id user list.
     *
     * @param userId the user id
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Booking> findAllByIdUser(int userId) throws DaoException;

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<Booking> findById(int id) throws DaoException;

    /**
     * Update status by id boolean.
     *
     * @param id     the id
     * @param status the status
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateStatusById(int id, String status) throws DaoException;
}
