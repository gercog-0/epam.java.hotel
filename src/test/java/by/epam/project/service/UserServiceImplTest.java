package by.epam.project.service;

import by.epam.project.exception.DaoException;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.dao.impl.UserDaoImpl;
import by.epam.project.model.entity.User;
import by.epam.project.model.service.impl.UserServiceImpl;

import by.epam.project.util.EncryptPassword;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

@PrepareForTest(UserDaoImpl.class)
public class UserServiceImplTest {
    private UserDaoImpl daoMock;
    private UserServiceImpl userService;

    private User userTest;
    private User userTestSecond;
    private Optional<User> optionalUserTest;
    private List<User> usersListTest;
    private List<User> sortedListByName;

    @BeforeClass
    public void setUp() {
        daoMock = mock(UserDaoImpl.class);
        userService = UserServiceImpl.getInstance();
        usersListTest = new ArrayList<>();
        sortedListByName = new ArrayList<>();
        Whitebox.setInternalState(UserDaoImpl.class, "instance", daoMock);

        userTest = new User("login", "email@gmail.com", "SName",
                "Surname", "+375(33)555-55-55", 0);
        userTestSecond = new User("twoLogin", "mail@mail.ru", "Name",
                "SecondSurname", "+375(55)555-55-55", 0);
        optionalUserTest = Optional.of(userTest);

        usersListTest.add(userTest);
        usersListTest.add(userTestSecond);

        sortedListByName.add(userTestSecond);
        sortedListByName.add(userTest);
    }

    @Test
    public void signUpUserShouldReturnTrue() {
        try {
            when(daoMock.add(any(User.class))).thenReturn(true);
            boolean condition = userService.signUpUser(userTest);
            assertTrue(condition);

        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void signUpUserShouldReturnFalse() {
        try {
            when(daoMock.add(any(User.class))).thenReturn(false);
            boolean condition = userService.signUpUser(userTest);
            assertFalse(condition);

        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void signUpUserShouldThrowException() throws ServiceException, DaoException {
        when(daoMock.add(any(User.class))).thenThrow(DaoException.class);
        userService.signUpUser(userTest);
    }

    @Test
    public void signInUserWithCorrectDataShouldReturnOptionalUser() {
        String login = "login";
        String password = "password";
        String encryptPassword = EncryptPassword.encryption(password);
        try {
            when(daoMock.findByLogin(any(String.class))).thenReturn(optionalUserTest);
            when(daoMock.findPasswordByLogin(any(String.class))).thenReturn(encryptPassword);
            Optional<User> actualOptionalUser = userService.signInUser(login, password);
            assertEquals(optionalUserTest, actualOptionalUser);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void signInUserWithIncorrectDataShouldReturnEmptyOptional() {
        String login = "!";
        String password = "password";
        String encryptPassword = EncryptPassword.encryption(password);
        try {
            when(daoMock.findByLogin(any(String.class))).thenReturn(optionalUserTest);
            when(daoMock.findPasswordByLogin(any(String.class))).thenReturn(encryptPassword);
            Optional<User> actualOptionalUser = userService.signInUser(login, password);
            assertEquals(Optional.empty(), actualOptionalUser);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void signInUserWithIncorrectPasswordShouldReturnEmptyOptional() {
        String login = "login";
        String password = "password";
        try {
            when(daoMock.findByLogin(any(String.class))).thenReturn(optionalUserTest);
            when(daoMock.findPasswordByLogin(any(String.class))).thenReturn(password);
            Optional<User> actualOptionalUser = userService.signInUser(login, password);
            assertEquals(Optional.empty(), actualOptionalUser);
        } catch (DaoException | ServiceException exp) {
            fail();
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void signInUserWithIncorrectDataShouldThrowException() throws ServiceException, DaoException {
        String login = "login";
        String password = "password";
        when(daoMock.findByLogin(any(String.class))).thenThrow(DaoException.class);
        when(daoMock.findPasswordByLogin(any(String.class))).thenThrow(DaoException.class);
        userService.signInUser(login, password);
    }

    @Test
    public void findAllUsersShouldReturnListWithUsers() {
        try {
            when(daoMock.findAll()).thenReturn(usersListTest);
            List<User> actualListUsers = userService.findAllUsers();
            assertEquals(usersListTest, actualListUsers);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void sortByParameterTypeNameShouldReturnSortedUsersList() {
        try {
            List<User> actualSortedList = userService.sortByParameter(usersListTest, "name");
            assertEquals(actualSortedList, sortedListByName);
        } catch (ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void sortByParameterIncorrectTypeShouldThrowException() throws ServiceException {
        userService.sortByParameter(usersListTest, "incorrectType");
    }

    @Test
    public void findUserByIdShouldReturnUser() {
        int userId = 1;
        try {
            when(daoMock.findById(any(Integer.class))).thenReturn(optionalUserTest);
            Optional<User> actualOptionalUser = userService.findUserById(userId);
            assertEquals(actualOptionalUser, optionalUserTest);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findUserByIdShouldThrowException() throws DaoException, ServiceException {
        int userId = 1;
        when(daoMock.findById(any(Integer.class))).thenThrow(DaoException.class);
        userService.findUserById(userId);
    }

    @Test
    public void findUserByPhoneShouldReturnUser() {
        String userPhone = "+375(33)33-33-33";
        try {
            when(daoMock.findByPhone(any(String.class))).thenReturn(optionalUserTest);
            Optional<User> actualOptionalUser = userService.findUserByPhone(userPhone);
            assertEquals(actualOptionalUser, optionalUserTest);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findUserByPhoneShouldThrowException() throws DaoException, ServiceException {
        String userPhone = "+375(33)33-33-33";
        when(daoMock.findByPhone(any(String.class))).thenThrow(DaoException.class);
        userService.findUserByPhone(userPhone);
    }

    @Test
    public void findUserByEmailShouldReturnUser() {
        String userEmail = "test@mail.ru";
        try {
            when(daoMock.findByEmail(any(String.class))).thenReturn(optionalUserTest);
            Optional<User> actualOptionalUser = userService.findUserByEmail(userEmail);
            assertEquals(actualOptionalUser, optionalUserTest);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findUserByEmailShouldThrowException() throws DaoException, ServiceException {
        String userEmail = "test@mail.ru";
        when(daoMock.findByEmail(any(String.class))).thenThrow(DaoException.class);
        userService.findUserByEmail(userEmail);
    }

    @Test
    public void paymentBookingCorrectPriceShouldReturnTrue() {
        double bookingPrice = 100;
        User userWithCorrectBalance = new User(5, "login", "email", "name", "surname",
                "phone", 400, false, true, 0);
        try {
            when(daoMock.updateBalanceByLogin(any(String.class), any(Double.class))).thenReturn(true);
            boolean condition = userService.paymentBooking(userWithCorrectBalance, bookingPrice);
            assertTrue(condition);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void paymentBookingIncorrectPriceShouldReturnFalse() {
        double bookingPrice = 500;
        User userWithIncorrectBalance = new User(5, "login", "email", "name", "surname",
                "phone", 400, false, true, 0);
        try {
            when(daoMock.updateBalanceByLogin(any(String.class), any(Double.class))).thenReturn(true);
            boolean condition = userService.paymentBooking(userWithIncorrectBalance, bookingPrice);
            assertFalse(condition);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void paymentBookingCorrectPriceShouldThrowException() throws DaoException, ServiceException {
        double bookingPrice = 100;
        User userWithCorrectBalance = new User(5, "login", "email", "name", "surname",
                "phone", 400, false, true, 0);
        when(daoMock.updateBalanceByLogin(any(String.class), any(Double.class))).thenThrow(DaoException.class);
        userService.paymentBooking(userWithCorrectBalance, bookingPrice);
    }

    @Test
    public void depositMoneyCorrectDataShouldReturnTrue() {
        String login = "login";
        double sum = 300;
        try {
            when(daoMock.updateBalanceByLogin(any(String.class), any(Double.class))).thenReturn(true);
            when(daoMock.findByLogin(any(String.class))).thenReturn(optionalUserTest);
            boolean condition = userService.depositMoney(login, sum);
            assertTrue(condition);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void depositMoneyIncorrectDataShouldReturnFalse() {
        String login = "login";
        double sum = 300;
        try {
            when(daoMock.updateBalanceByLogin(any(String.class), any(Double.class))).thenReturn(true);
            when(daoMock.findByLogin(any(String.class))).thenReturn(Optional.empty());
            boolean condition = userService.depositMoney(login, sum);
            assertFalse(condition);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void depositMoneyShouldThrowException() throws DaoException, ServiceException {
        String login = "login";
        double sum = 300;
        when(daoMock.updateBalanceByLogin(any(String.class), any(Double.class))).thenThrow(DaoException.class);
        when(daoMock.findByLogin(any(String.class))).thenThrow(DaoException.class);
        userService.depositMoney(login, sum);
    }

    @Test
    public void updatePasswordByLoginCorrectDataShouldReturnTrue() {
        String login = "login";
        String password = "password";
        try {
            when(daoMock.updatePasswordByLogin(any(String.class), any(String.class))).thenReturn(true);
            boolean condition = userService.updatePasswordByLogin(login, password);
            assertTrue(condition);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void updatePasswordByLoginIncorrectDataShouldReturnFalse() {
        String login = "!";
        String password = "!";
        try {
            boolean condition = userService.updatePasswordByLogin(login, password);
            assertFalse(condition);
        } catch (ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void updatePasswordByLoginIncorrectDataShouldThrowException() throws DaoException, ServiceException {
        String login = "login";
        String password = "password";
        when(daoMock.updatePasswordByLogin(any(String.class), any(String.class))).thenThrow(DaoException.class);
        userService.updatePasswordByLogin(login, password);
    }

    @Test
    public void banUserShouldReturnTrue() {
        String login = "login";
        try {
            when(daoMock.ban(any(String.class))).thenReturn(true);
            boolean condition = userService.banUser(login);
            assertTrue(condition);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void banUserShouldThrowException() throws DaoException, ServiceException {
        String login = "login";
        when(daoMock.ban(any(String.class))).thenThrow(DaoException.class);
        userService.banUser(login);
    }

    @Test
    public void unbanUserShouldReturnTrue() {
        String login = "login";
        try {
            when(daoMock.unBan(any(String.class))).thenReturn(true);
            boolean condition = userService.unBanUser(login);
            assertTrue(condition);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void unbanUserShouldThrowException() throws DaoException, ServiceException {
        String login = "login";
        when(daoMock.unBan(any(String.class))).thenThrow(DaoException.class);
        userService.unBanUser(login);
    }

    @Test
    public void activateUserShouldReturnTrue() {
        String login = "login";
        try {
            when(daoMock.activateUser(any(String.class))).thenReturn(true);
            boolean condition = userService.activateUser(login);
            assertTrue(condition);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void activateUserShouldThrowException() throws DaoException, ServiceException {
        String login = "login";
        when(daoMock.activateUser(any(String.class))).thenThrow(DaoException.class);
        userService.activateUser(login);
    }

    @AfterClass
    public void tierDown() {
        userService = null;
        daoMock = null;
        userTest = null;
        userTestSecond = null;
        optionalUserTest = Optional.empty();
        usersListTest = null;
    }
}
