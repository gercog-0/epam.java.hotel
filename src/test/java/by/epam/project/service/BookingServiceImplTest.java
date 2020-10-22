package by.epam.project.service;

import by.epam.project.exception.DaoException;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.dao.impl.BookingDaoImpl;
import by.epam.project.model.dao.impl.RoomDaoImpl;
import by.epam.project.model.entity.Booking;
import by.epam.project.model.entity.Room;
import by.epam.project.model.entity.User;
import by.epam.project.model.service.impl.BookingServiceImpl;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.testng.Assert.*;

@PrepareForTest(RoomDaoImpl.class)
public class BookingServiceImplTest {
    private BookingDaoImpl bookingDao;
    private BookingServiceImpl bookingService;

    private Booking bookingTest;
    private Booking bookingTestSecond;
    private Optional<Booking> optionalBookingTest;
    private List<Booking> listBookingsTest;
    private List<Booking> sortedlistBookingsTest;


    @BeforeClass
    public void setUp() {
        bookingDao = mock(BookingDaoImpl.class);
        bookingService = BookingServiceImpl.getInstance();
        Whitebox.setInternalState(BookingDaoImpl.class, "instance", bookingDao);

        bookingTest = new Booking(new User("login", "mail", "name", "surname", "phone", 0),
                new Room(100, Room.Comfort.ECONOMY, 1000, true, 5),
                new Date(), new Date(), Booking.Status.ACTIVE, 500);
        bookingTestSecond = new Booking(new User("secondLogin", "secondMail", "Sname", "Ssurname", "Sphone", 0),
                new Room(100, Room.Comfort.ECONOMY, 1000, true, 5),
                new Date(1603054800000L), new Date(1603141200000L), Booking.Status.ACTIVE, 500);
        optionalBookingTest = Optional.of(bookingTest);
        listBookingsTest = new ArrayList<>();
        sortedlistBookingsTest = new ArrayList<>();
        listBookingsTest.add(bookingTest);
        listBookingsTest.add(bookingTestSecond);

        sortedlistBookingsTest.add(bookingTestSecond);
        sortedlistBookingsTest.add(bookingTest);
    }

    @DataProvider(name = "datesCorrectBooking")
    public Object[][] createCorrectDates() {
        return new Object[][]{
                {"2020-12-01", "2021-12-11"},
                {"2021-01-01", "2021-04-15"},
                {"2029-11-11", "2030-12-21"},
                {"2020-07-15", "2024-09-11"},
                {"2040-02-20", "2044-02-21"},
        };
    }

    @DataProvider(name = "datesIncorrectBooking")
    public Object[][] createIncorrectDates() {
        return new Object[][]{
                {"", "2021-12-11"},
                {"2021-01-01", "001-0!0-15"},
                {"2029-11-11", "2030s-12-21"},
                {"2020-07-1f5", "2024-09a-11"},
                {"2040-0220", "2044-02-21"},
        };
    }

    @DataProvider(name = "correctDataToUpdateBooking")
    public Object[][] createCorrectDataToUpdateBooking() {
        return new Object[][]{
                {"1", "waiting"},
                {"34", "rejected"},
                {"33", "active"},
                {"1001", "rejected"},
                {"13", "active"},
        };
    }

    @DataProvider(name = "incorrectDataToUpdateBooking")
    public Object[][] createIncorrectDataToUpdateBooking() {
        return new Object[][]{
                {"1", "waiti1ng"},
                {"-5", "reject!ed"},
                {"33", "no status"},
                {"1001", ""},
                {"13", "abcd"},
        };
    }

    @Test(dataProvider = "datesCorrectBooking")
    public void makeBookingCorrectDataShouldReturnTrue(String arrivalDateString,
                                                       String departureDateString) {
        User userTest = new User("login", "email@gmail.com", "SName",
                "Surname", "+375(33)555-55-55", 0);
        Room roomTest = new Room(100, Room.Comfort.ECONOMY, 700,
                true, 5);

        try {
            when(bookingDao.add(any(Booking.class))).thenReturn(true);
            boolean condition = bookingService.makeBooking(arrivalDateString, departureDateString,
                    userTest, roomTest);
            assertTrue(condition);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(dataProvider = "datesIncorrectBooking")
    public void makeBookingIncorrectDataShouldReturnFalse(String arrivalDateString,
                                                          String departureDateString) {
        User userTest = new User("login", "email@gmail.com", "SName",
                "Surname", "+375(33)555-55-55", 0);
        Room roomTest = new Room(100, Room.Comfort.ECONOMY, 700,
                true, 5);

        try {
            when(bookingDao.add(any(Booking.class))).thenReturn(true);
            boolean condition = bookingService.makeBooking(arrivalDateString, departureDateString,
                    userTest, roomTest);
            assertFalse(condition);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void makeBookingShouldThrowException() throws DaoException, ServiceException {
        when(bookingDao.add(any(Booking.class))).thenThrow(DaoException.class);
        bookingService.makeBooking("2020-12-20", "2021-12-21",
                new User("login", "mail", "name", "surname", "phone", 0),
                new Room(100, Room.Comfort.ECONOMY, 1000, true, 5));
    }

    @Test
    public void findBookingsByUserIdShouldReturnListWithBookings() {
        try {
            when(bookingDao.findAllByIdUser(any(Integer.class))).thenReturn(listBookingsTest);
            List<Booking> actualListBookings = bookingService.findBookingsByUserId(1);
            assertEquals(actualListBookings, listBookingsTest);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findBookingsByUserIdShouldThrowException() throws DaoException, ServiceException {
        when(bookingDao.findAllByIdUser(any(Integer.class))).thenThrow(DaoException.class);
        bookingService.findBookingsByUserId(1);
    }

    @Test
    public void findBookingByStatusShouldReturnListWithBookings() {
        try {
            when(bookingDao.findByStatus(any())).thenReturn(listBookingsTest);
            List<Booking> actualListBookings = bookingService.findBookingsByStatus("waiting");
            assertEquals(actualListBookings, listBookingsTest);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findBookingByStatusShouldThrowException() throws DaoException, ServiceException {
        when(bookingDao.findByStatus(any())).thenThrow(DaoException.class);
        bookingService.findBookingsByStatus("waiting");
    }

    @Test
    public void findAllBookingsShouldReturnListWithBookings() {
        try {
            when(bookingDao.findAll()).thenReturn(listBookingsTest);
            List<Booking> actualListBookings = bookingService.findAllBookings();
            assertEquals(actualListBookings, listBookingsTest);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findAllBookingsShouldThrowException() throws DaoException, ServiceException {
        when(bookingDao.findAll()).thenThrow(DaoException.class);
        bookingService.findAllBookings();
    }

    @Test
    public void sortByParameterTypeArrivalDateShouldReturnSortedList() {
        try {
            String sortType = "arrival_date";
            List<Booking> actualSortedList = bookingService.sortByParameter(listBookingsTest, sortType);
            assertEquals(actualSortedList, listBookingsTest);
        } catch (ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void sortByParameterIncorrectSortTypeShouldThrowException() throws ServiceException {
        String sortType = "arrival!date";
        bookingService.sortByParameter(listBookingsTest, sortType);
    }

    @Test
    public void findBookingByIdShouldReturnOptionalBooking() {
        try {
            when(bookingDao.findById(any(Integer.class))).thenReturn(optionalBookingTest);
            Optional<Booking> actualOptionalBooking = bookingService.findBookingById("100");
            assertEquals(actualOptionalBooking, optionalBookingTest);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findBookingByIdShouldThrowException() throws ServiceException, DaoException {
        when(bookingDao.findById(any(Integer.class))).thenThrow(DaoException.class);
        bookingService.findBookingById("100");
    }

    @Test(dataProvider = "correctDataToUpdateBooking")
    public void updateBookingStatusCorrectDataShouldReturnTrue(String id, String status) {
        try {
            when(bookingDao.updateStatusById(any(Integer.class), any(String.class))).thenReturn(true);
            boolean condition = bookingService.updateBookingStatus(id, status);
            assertTrue(condition);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(dataProvider = "incorrectDataToUpdateBooking")
    public void updateBookingStatusIncorrectDataShouldReturnFalse(String id, String status) {
        try {
            when(bookingDao.updateStatusById(any(Integer.class), any(String.class))).thenReturn(false);
            boolean condition = bookingService.updateBookingStatus(id, status);
            assertFalse(condition);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void updateBookingStatusShouldThrowException() throws DaoException, ServiceException{
        when(bookingDao.updateStatusById(any(Integer.class), any(String.class))).thenThrow(DaoException.class);
        bookingService.updateBookingStatus("1", "economy");

    }

    @AfterClass
    public void tierDown() {
        bookingDao = null;
        bookingService = null;
        bookingTest = null;
        bookingTestSecond = null;
        optionalBookingTest = Optional.empty();
        listBookingsTest = null;
        sortedlistBookingsTest = null;
    }
}
