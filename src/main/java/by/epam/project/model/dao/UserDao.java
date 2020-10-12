package by.epam.project.model.dao;

import by.epam.project.entity.User;
import by.epam.project.exception.DaoException;
import by.epam.project.model.creator.UserCreator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static by.epam.project.util.RequestParameter.*;

public interface UserDao extends BaseDaoSql<User> {
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

    default User createUserFromResultSet(ResultSet resultSet) throws DaoException {
        UserCreator creator = UserCreator.getInstance();

        try {
            int userId = resultSet.getInt(USER_ID);
            String userLogin = resultSet.getString(USER_LOGIN);
            String userEmail = resultSet.getString(USER_EMAIL);
            String userName = resultSet.getString(USER_NAME);
            String userSurname = resultSet.getString(USER_SURNAME);
            String userPhone = resultSet.getString(USER_PHONE);
            double userBalance = resultSet.getDouble(USER_BALANCE);
            boolean userIsBanned = resultSet.getBoolean(USER_IS_BANNED);
            boolean userIsActivated = resultSet.getBoolean(USER_IS_ACTIVATED);
            int userRoleId = resultSet.getInt(USER_ROLE_ID);

            User createdUser = creator.createUser(userId, userLogin, userEmail, userName,
                    userSurname, userPhone, userBalance, userIsBanned, userIsActivated, userRoleId);
            return createdUser;
        } catch (SQLException exp) {
            throw new DaoException("Error while creating user from resultSet", exp);
        }
    }
}
