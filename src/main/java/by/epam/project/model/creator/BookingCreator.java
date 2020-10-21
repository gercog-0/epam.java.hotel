package by.epam.project.model.creator;

import by.epam.project.model.entity.Booking;
import by.epam.project.model.entity.Room;
import by.epam.project.model.entity.User;

import java.util.Date;

public class BookingCreator {
    public static BookingCreator instance = new BookingCreator();

    private BookingCreator() {
    }

    public static BookingCreator getInstance() {
        return instance;
    }

    public Booking createBooking(int bookingId, User user, Room room, Date arrivalDate,
                                 Date departureDate, Booking.Status status, double totalPrice) {
        Booking newBooking = new Booking(bookingId, user, room, arrivalDate, departureDate, status, totalPrice);
        return newBooking;
    }

    public Booking createBooking(User user, Room room, Date arrivalDate,
                                 Date departureDate, double totalPrice) {
        Booking newBooking = new Booking(user, room, arrivalDate, departureDate,
                Booking.Status.WAITING, totalPrice);
        return newBooking;
    }
}
