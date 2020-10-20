package by.epam.project.model.dao;

import by.epam.project.entity.User;
import by.epam.project.exception.DaoException;
import by.epam.project.model.creator.UserCreator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static by.epam.project.util.RequestParameterName.*;

public interface UserDao extends BaseDao<User> {
    Optional<User> findById(int id) throws DaoException;

    Optional<User> findByLogin(String login) throws DaoException;

    Optional<User> findByEmail(String email) throws DaoException;

    Optional<User> findByPhone(String phone) throws DaoException;

    String findPasswordByLogin(String login) throws DaoException;

    boolean activateUser(String login) throws DaoException;

    boolean ban(String login) throws DaoException;

    boolean unBan(String login) throws DaoException;

    boolean updatePasswordByLogin(String login, String password) throws DaoException;

    boolean updateBalanceByLogin(String login, double sum) throws DaoException;
}
