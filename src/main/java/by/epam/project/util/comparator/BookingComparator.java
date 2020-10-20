package by.epam.project.util.comparator;

import by.epam.project.entity.Booking;

import java.util.Comparator;

public enum BookingComparator {
    ARRIVAL_DATE((booking1, booking2) -> {
        if (booking1.getArrivalDate().before(booking2.getArrivalDate())) {
            return 1;
        } else if (booking1.getArrivalDate().after(booking2.getArrivalDate())) {
            return -1;
        } else {
            return 0;
        }
    });

    private final Comparator<Booking> comparator;

    BookingComparator(Comparator<Booking> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Booking> getComparator() {
        return comparator;
    }
}