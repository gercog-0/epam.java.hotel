package by.epam.project.model.service.impl;

import by.epam.project.entity.User;
import by.epam.project.exception.DaoException;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.dao.impl.UserDaoImpl;
import by.epam.project.model.service.UserService;
import by.epam.project.util.EncryptPassword;
import by.epam.project.validator.impl.UserValidatorImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static by.epam.project.util.RequestParameter.*;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public Optional<User> signInUser(String login, String password) throws ServiceException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        UserValidatorImpl validator = UserValidatorImpl.getInstance();

        if (!validator.isLoginCorrect(login) || !validator.isPasswordCorrect(password)) {
            return Optional.empty();
        }

        try {
            Optional<User> foundUser = userDao.findByLogin(login);
            String userPassword = userDao.findPasswordByLogin(login);

            if (foundUser.isEmpty() ||
                    !EncryptPassword.encryption(password).equals(userPassword)) {
                foundUser = Optional.empty();
            }
            return foundUser;
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
    }

    @Override
    public User signUpUser(User user) throws ServiceException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        try {
            userDao.add(user);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return user;
    }


    public Map<String, String> defineSignUpData(String login, String password
            , String email, String name, String surname, String phone) throws ServiceException {
        UserValidatorImpl validator = UserValidatorImpl.getInstance();
        UserDaoImpl userDao = UserDaoImpl.getInstance();

        Map<String, String> signUpData = validator.validateParameters(login, password, email, name, surname, phone);
        try {
            signUpData.put(LOGIN_UNIQUE, userDao.findByLogin(login).isEmpty() ? login : NOT_UNIQUE);
            signUpData.put(EMAIL_UNIQUE, userDao.findByEmail(email).isEmpty() ? email : NOT_UNIQUE);
            signUpData.put(PHONE_UNIQUE, userDao.findByPhone(phone).isEmpty() ? phone : NOT_UNIQUE);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return signUpData;
    }

    @Override
    public List<User> findAllUsers() throws ServiceException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        List<User> userList;

        try {
            userList = userDao.findAll();
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return userList;
    }

    @Override
    public Optional<User> findUserById(int id) throws ServiceException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        try {
            return userDao.findById(id);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
    }

    @Override
    public Optional<User> findUserByPhone(String phone) throws ServiceException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        try {
            return userDao.findByPhone(phone);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
    }

    @Override
    public Optional<User> findUserByEmail(String email) throws ServiceException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        try {
            return userDao.findByEmail(email);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
    }

    @Override
    public boolean depositMoney(String login, double sum) throws ServiceException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        boolean isMadeDeposit = false;
        try {
            Optional<User> userOptional = userDao.findByLogin(login);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                double currentBalance = user.getBalance();
                double newBalance = currentBalance + sum;
                userDao.updateBalanceByLogin(login, newBalance);
                isMadeDeposit = true;
            }
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return isMadeDeposit;
    }

    @Override
    public boolean updatePasswordByLogin(String login, String password) throws ServiceException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        UserValidatorImpl validator = UserValidatorImpl.getInstance();
        if (!validator.isLoginCorrect(login) || !validator.isPasswordCorrect(password)) {
            return false;
        }
        boolean isUpdate;
        try {
            String encryptPassword = EncryptPassword.encryption(password);
            isUpdate = userDao.updatePasswordByLogin(login, encryptPassword);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return isUpdate;
    }

    @Override
    public boolean banUser(String login) throws ServiceException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        try {
            return userDao.ban(login);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
    }

    @Override
    public boolean unBanUser(String login) throws ServiceException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        try {
            return userDao.unBan(login);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
    }

    @Override
    public boolean activateUser(String login) throws ServiceException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        try {
            return userDao.activateUser(login);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
    }
}
