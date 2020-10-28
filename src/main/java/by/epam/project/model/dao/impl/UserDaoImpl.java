package by.epam.project.model.dao.impl;

import by.epam.project.exception.DaoException;
import by.epam.project.model.connection.ConnectionPool;
import by.epam.project.model.dao.SqlQuery;
import by.epam.project.model.dao.UserDao;
import by.epam.project.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.epam.project.util.RequestParameterName.*;

public class UserDaoImpl implements UserDao {
    private static UserDaoImpl instance = new UserDaoImpl();

    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        return instance;
    }

    @Override
    public boolean add(User user) throws DaoException {
        boolean update;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.ADD_USER)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setString(5, user.getPhone());
            statement.setDouble(6, user.getBalance());
            statement.setBoolean(7, user.isBanned());
            statement.setBoolean(8, user.isActivated());
            statement.setInt(9, user.getRole().getRoleId());

            update = statement.executeUpdate() > 0;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return update;
    }

    @Override
    public List<User> findAll() throws DaoException {
        List<User> allUsers = new ArrayList<>();

        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_ALL_USERS)) {
            statement.setInt(1, User.Role.USER.getRoleId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = createUserFromResultSet(resultSet);
                allUsers.add(user);
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return allUsers;
    }

    @Override
    public Optional<User> findById(int id) throws DaoException {
        Optional<User> user = Optional.empty();

        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_USER_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = Optional.of(createUserFromResultSet(resultSet));
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return user;
    }

    @Override
    public Optional<User> findByLogin(String login) throws DaoException {
        Optional<User> foundUser = Optional.empty();

        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_USER_BY_LOGIN)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                foundUser = Optional.of(createUserFromResultSet(resultSet));
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return foundUser;
    }

    @Override
    public Optional<User> findByEmail(String email) throws DaoException {
        Optional<User> user = Optional.empty();

        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_USER_BY_EMAIL)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = Optional.of(createUserFromResultSet(resultSet));
            }
            return user;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
    }

    @Override
    public Optional<User> findByPhone(String phone) throws DaoException {
        Optional<User> user = Optional.empty();

        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_USER_BY_PHONE)) {
            statement.setString(1, phone);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = Optional.of(createUserFromResultSet(resultSet));
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return user;
    }

    @Override
    public String findPasswordByLogin(String login) throws DaoException {
        String userPassword = null;

        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_PASSWORD_BY_LOGIN)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userPassword = resultSet.getString(USER_PASSWORD);
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return userPassword;
    }

    @Override
    public boolean activateUser(String login) throws DaoException {
        boolean isUpdate;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.ACTIVATE_USER)) {
            statement.setString(1, login);
            isUpdate = statement.executeUpdate() > 0;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return isUpdate;
    }

    @Override
    public boolean ban(String login) throws DaoException {
        boolean isUpdate;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.BAN_USER)) {
            statement.setString(1, login);
            isUpdate = statement.executeUpdate() > 0;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return isUpdate;
    }

    @Override
    public boolean unBan(String login) throws DaoException {
        boolean isUpdate;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.UN_BANE_USER)) {
            statement.setString(1, login);
            isUpdate = statement.executeUpdate() > 0;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return isUpdate;
    }

    @Override
    public boolean updatePasswordByLogin(String login, String password) throws DaoException {
        boolean isUpdate = false;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.UPDATE_PASSWORD_BY_LOGIN)) {
            statement.setString(1, password);
            statement.setString(2, login);
            isUpdate = statement.executeUpdate() > 0;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return isUpdate;
    }

    @Override
    public boolean updateBalanceByLogin(String login, double sum) throws DaoException {
        boolean isUpdate = false;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.UPDATE_BALANCE_BY_LOGIN)) {
            statement.setDouble(1, sum);
            statement.setString(2, login);
            isUpdate = statement.executeUpdate() > 0;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return isUpdate;
    }
}
