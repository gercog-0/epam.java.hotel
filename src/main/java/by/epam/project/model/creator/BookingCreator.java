package by.epam.project.model.creator;

import by.epam.project.model.entity.Booking;
import by.epam.project.model.entity.Room;
import by.epam.project.model.entity.User;

import java.util.Date;

/**
 * Booking creator.
 */
public class BookingCreator {
    /**
     * The constant instance.
     */
    public static BookingCreator instance = new BookingCreator();

    private BookingCreator() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static BookingCreator getInstance() {
        return instance;
    }

    /**
     * Create booking.
     *
     * @param bookingId     the booking id
     * @param user          the user
     * @param room          the room
     * @param arrivalDate   the arrival date
     * @param departureDate the departure date
     * @param status        the status
     * @param totalPrice    the total price
     * @return the booking
     */
    public Booking createBooking(int bookingId, User user, Room room, Date arrivalDate,
                                 Date departureDate, Booking.Status status, double totalPrice) {
        Booking newBooking = new Booking(bookingId, user, room, arrivalDate, departureDate, status, totalPrice);
        return newBooking;
    }

    /**
     * Create booking.
     *
     * @param user          the user
     * @param room          the room
     * @param arrivalDate   the arrival date
     * @param departureDate the departure date
     * @param totalPrice    the total price
     * @return the booking
     */
    public Booking createBooking(User user, Room room, Date arrivalDate,
                                 Date departureDate, double totalPrice) {
        Booking newBooking = new Booking(user, room, arrivalDate, departureDate,
                Booking.Status.WAITING, totalPrice);
        return newBooking;
    }
}
