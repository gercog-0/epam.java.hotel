package by.epam.project.service;

import by.epam.project.exception.DaoException;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.dao.impl.RoomDaoImpl;
import by.epam.project.model.entity.Room;
import by.epam.project.model.service.impl.RoomServiceImpl;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

@PrepareForTest(RoomDaoImpl.class)
public class RoomServiceImplTest {
    private RoomDaoImpl roomDao;
    private RoomServiceImpl roomService;

    private Room roomTest;
    private Room roomTestSecond;
    private Optional<Room> roomOptionalTest;
    private List<Room> roomsListTest;
    private List<Room> sortedListByPrice;

    @BeforeClass
    public void setUp() {
        roomDao = mock(RoomDaoImpl.class);
        roomService = RoomServiceImpl.getInstance();
        Whitebox.setInternalState(RoomDaoImpl.class, "instance", roomDao);
        roomTest = new Room(100, Room.Comfort.ECONOMY, 700,
                true, 5);
        roomTestSecond = new Room(200, Room.Comfort.APARTMENTS, 400,
                true, 5);
        roomOptionalTest = Optional.of(roomTest);
        roomsListTest = new ArrayList<>();
        sortedListByPrice = new ArrayList<>();

        roomsListTest.add(roomTest);
        roomsListTest.add(roomTestSecond);
        sortedListByPrice.add(roomTestSecond);
        sortedListByPrice.add(roomTest);

    }

    @DataProvider(name = "correctDataToFindRoomByNumber")
    public Object[] createCorrectDataToFindRoomByNumber() {
        return new Object[]{
                "300", "201", "499", "101", "333"
        };
    }

    @DataProvider(name = "incorrectDataToFindRoomByNumber")
    public Object[] createIncorrectDataToFindRoomByNumber() {
        return new Object[]{
                "99", "501", "-1", "1001", ""
        };
    }

    @Test(dataProvider = "correctDataToFindRoomByNumber")
    public void findByNumberCorrectNumberShouldReturnOptionalRoom(String number) {
        try {
            when(roomDao.findByNumber(any(Integer.class))).thenReturn(roomOptionalTest);
            Optional<Room> actualOptionalRoom = roomService.findByNumber(number);
            assertEquals(actualOptionalRoom, roomOptionalTest);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(dataProvider = "incorrectDataToFindRoomByNumber")
    public void findByNumberIncorrectNumberShouldReturnOptionalEmpty(String number) {
        try {
            when(roomDao.findByNumber(any(Integer.class))).thenReturn(roomOptionalTest);
            Optional<Room> actualOptionalRoom = roomService.findByNumber(number);
            assertEquals(actualOptionalRoom, Optional.empty());
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByNumberShouldReturnException() throws DaoException, ServiceException {
        when(roomDao.findByNumber(any(Integer.class))).thenThrow(DaoException.class);
        roomService.findByNumber("100");
    }

    @Test
    public void sortByParameterTypeNameShouldReturnSortedUsersList() {
        try {
            List<Room> actualSortedList = roomService.sortByParameter(roomsListTest, "price");
            assertEquals(actualSortedList, sortedListByPrice);
        } catch (ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void sortByParameterIncorrectTypeShouldThrowException() throws ServiceException {
        roomService.sortByParameter(roomsListTest, "incorrectType");
    }

    @Test
    public void findFreeRoomsByParametersShouldReturnFreeRoomsList() {
        String comfort = "economy";
        String placeAmount = "3";
        String dateFrom = "2020-22-10";
        String dateTo = "2020-22-15";

        try {
            when(roomDao.findFree(any(String.class), any(Integer.class),
                    any(Long.class), any(Long.class))).thenReturn(roomsListTest);
            List<Room> actualFreeRooms = roomService.findFreeRoomsByParameters(comfort,
                    placeAmount, dateFrom, dateTo);
            assertEquals(actualFreeRooms, roomsListTest);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findFreeRoomsByParametersShouldThrowException() throws ServiceException, DaoException {
        String comfort = "economy";
        String placeAmount = "3";
        String dateFrom = "2020-22-10";
        String dateTo = "2020-22-15";
        when(roomDao.findFree(any(String.class), any(Integer.class),
                any(Long.class), any(Long.class))).thenThrow(DaoException.class);
        roomService.findFreeRoomsByParameters(comfort, placeAmount, dateFrom, dateTo);
    }

    @Test
    public void findAllRoomsShouldReturnListRooms() {
        try {
            when(roomDao.findAll()).thenReturn(roomsListTest);
            List<Room> actualAllRooms = roomService.findAllRooms();
            assertEquals(actualAllRooms, roomsListTest);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findAllRoomsShouldThrowException() throws DaoException, ServiceException {
        when(roomDao.findAll()).thenThrow(DaoException.class);
        roomService.findAllRooms();
    }

    @Test
    public void addRoomShouldReturnTrue() {
        try {
            when(roomDao.add(any(Room.class))).thenReturn(true);
            boolean condition = roomService.addRoom(roomTest);
            assertTrue(condition);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void addRoomShouldThrowException() throws DaoException, ServiceException {
        when(roomDao.add(any(Room.class))).thenThrow(DaoException.class);
        roomService.addRoom(roomTest);
    }

    @Test
    public void activateRoomShouldReturnTrue() {
        String number = "100";
        try {
            when(roomDao.activateRoom(any(Integer.class))).thenReturn(true);
            roomService.activateRoom(number);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void activateRoomShouldThrowException() throws DaoException, ServiceException {
        String number = "100";
        when(roomDao.activateRoom(any(Integer.class))).thenThrow(DaoException.class);
        roomService.activateRoom(number);
    }

    @Test
    public void inactivateRoomShouldReturnTrue() {
        String number = "100";
        try {
            when(roomDao.inactiveRoom(any(Integer.class))).thenReturn(true);
            roomService.inactivateRoom(number);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void inactivateRoomShouldThrowException() throws DaoException, ServiceException {
        String number = "100";
        when(roomDao.inactiveRoom(any(Integer.class))).thenThrow(DaoException.class);
        roomService.inactivateRoom(number);
    }

    @AfterClass
    public void tierDown() {
        roomDao = null;
        roomService = null;
        roomTest = null;
        roomOptionalTest = Optional.empty();
        roomsListTest = null;
        sortedListByPrice = null;
    }
}
