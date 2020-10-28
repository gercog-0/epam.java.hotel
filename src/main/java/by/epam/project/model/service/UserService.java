package by.epam.project.model.service;

import by.epam.project.exception.ServiceException;
import by.epam.project.model.entity.User;

import java.util.List;
import java.util.Optional;


/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Sign in user optional.
     *
     * @param login    the login
     * @param password the password
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<User> signInUser(String login, String password) throws ServiceException;

    /**
     * Sign up user boolean.
     *
     * @param user the user
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean signUpUser(User user) throws ServiceException;

    /**
     * Find all users list.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    List<User> findAllUsers() throws ServiceException;

    /**
     * Sort by parameter list.
     *
     * @param users    the users
     * @param sortType the sort type
     * @return the list
     * @throws ServiceException the service exception
     */
    List<User> sortByParameter(List<User> users, String sortType) throws ServiceException;

    /**
     * Find user by id optional.
     *
     * @param id the id
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<User> findUserById(int id) throws ServiceException;

    /**
     * Find user by phone optional.
     *
     * @param phone the phone
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<User> findUserByPhone(String phone) throws ServiceException;

    /**
     * Find user by email optional.
     *
     * @param email the email
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<User> findUserByEmail(String email) throws ServiceException;


    /**
     * Find user by login optional.
     *
     * @param login the login
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<User> findUserByLogin(String login) throws ServiceException;

    /**
     * Deposit money boolean.
     *
     * @param login the login
     * @param sum   the sum
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean depositMoney(String login, double sum) throws ServiceException;

    /**
     * Update password by login boolean.
     *
     * @param login    the login
     * @param password the password
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean updatePasswordByLogin(String login, String password) throws ServiceException;

    /**
     * Payment booking boolean.
     *
     * @param user         the user
     * @param bookingPrice the booking price
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean paymentBooking(User user, double bookingPrice) throws ServiceException;

    /**
     * Ban user boolean.
     *
     * @param login the login
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean banUser(String login) throws ServiceException;

    /**
     * Un ban user boolean.
     *
     * @param login the login
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean unBanUser(String login) throws ServiceException;

    /**
     * Activate user boolean.
     *
     * @param login the login
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean activateUser(String login) throws ServiceException;
}
