package by.epam.project.service;

import by.epam.project.exception.DaoException;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.dao.UserDao;
import by.epam.project.model.dao.impl.UserDaoImpl;
import by.epam.project.model.entity.User;
import by.epam.project.model.service.UserService;
import by.epam.project.model.service.impl.UserServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class UserServiceImplTest {
    @Mock
    private UserDaoImpl daoMock;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void signUpUserShouldReturnTrue() {
        User user = new User("gercog", "ivangc@gmail.com", "Ivan",
                "Yanushkevich", "+375(33)632-33-12", 0);

        try {
            when(daoMock.add(any(User.class))).thenReturn(true);
            boolean condition = userService.signUpUser(user);
            assertTrue(condition);

        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @AfterClass
    public void tierDown() {
        userService = null;
        daoMock = null;
    }
}
