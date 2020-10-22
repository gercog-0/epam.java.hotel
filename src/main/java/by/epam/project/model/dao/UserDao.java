package by.epam.project.model.dao;

import by.epam.project.exception.DaoException;

import by.epam.project.model.entity.User;

import java.util.Optional;

/**
 * The interface User dao.
 */
public interface UserDao extends BaseDao<User> {
    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<User> findById(int id) throws DaoException;

    /**
     * Find by login optional.
     *
     * @param login the login
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<User> findByLogin(String login) throws DaoException;

    /**
     * Find by email optional.
     *
     * @param email the email
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<User> findByEmail(String email) throws DaoException;

    /**
     * Find by phone optional.
     *
     * @param phone the phone
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<User> findByPhone(String phone) throws DaoException;

    /**
     * Find password by login string.
     *
     * @param login the login
     * @return the string
     * @throws DaoException the dao exception
     */
    String findPasswordByLogin(String login) throws DaoException;

    /**
     * Activate user boolean.
     *
     * @param login the login
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean activateUser(String login) throws DaoException;

    /**
     * Ban boolean.
     *
     * @param login the login
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean ban(String login) throws DaoException;

    /**
     * Un ban boolean.
     *
     * @param login the login
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean unBan(String login) throws DaoException;

    /**
     * Update password by login boolean.
     *
     * @param login    the login
     * @param password the password
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updatePasswordByLogin(String login, String password) throws DaoException;

    /**
     * Update balance by login boolean.
     *
     * @param login the login
     * @param sum   the sum
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateBalanceByLogin(String login, double sum) throws DaoException;
}
