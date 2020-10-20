package by.epam.project.model.service;

import by.epam.project.entity.Booking;
import by.epam.project.entity.User;
import by.epam.project.exception.ServiceException;

import java.util.List;
import java.util.Optional;


public interface UserService {
    Optional<User> signInUser(String login, String password) throws ServiceException;

    boolean signUpUser(User user) throws ServiceException;

    List<User> findAllUsers() throws ServiceException;

    List<User> sortByParameter(List<User> users, String sortType) throws ServiceException;

    Optional<User> findUserById(int id) throws ServiceException;

    Optional<User> findUserByPhone(String phone) throws ServiceException;

    Optional<User> findUserByEmail(String email) throws ServiceException;

    boolean depositMoney(String login, double sum) throws ServiceException;

    boolean updatePasswordByLogin(String login, String password) throws ServiceException;

    boolean paymentBooking(User user, double bookingPrice) throws ServiceException;

    boolean banUser(String login) throws ServiceException;

    boolean unBanUser(String login) throws ServiceException;

    boolean activateUser(String login) throws ServiceException;
}
