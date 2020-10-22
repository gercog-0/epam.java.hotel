package by.epam.project.model.dao;

import by.epam.project.model.entity.Room;
import by.epam.project.exception.DaoException;

import java.util.List;
import java.util.Optional;

/**
 * The interface Room dao.
 */
public interface RoomDao extends BaseDao<Room> {
    /**
     * Find by number optional.
     *
     * @param number the number
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<Room> findByNumber(int number) throws DaoException;

    /**
     * Find free list.
     *
     * @param comfort     the comfort
     * @param placeAmount the place amount
     * @param from        the from
     * @param to          the to
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Room> findFree(String comfort, int placeAmount, long from, long to) throws DaoException;

    /**
     * Find by comfort list.
     *
     * @param comfort the comfort
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Room> findByComfort(String comfort) throws DaoException;

    /**
     * Find by place amount list.
     *
     * @param placeAmount the place amount
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Room> findByPlaceAmount(int placeAmount) throws DaoException;

    /**
     * Find by status list.
     *
     * @param isActive the is active
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Room> findByStatus(boolean isActive) throws DaoException;

    /**
     * Activate room boolean.
     *
     * @param number the number
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean activateRoom(int number) throws DaoException;

    /**
     * Inactive room boolean.
     *
     * @param number the number
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean inactiveRoom(int number) throws DaoException;
}
