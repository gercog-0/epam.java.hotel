package by.epam.project.comparator;

import by.epam.project.entity.Room;

import java.util.Comparator;

public enum RoomComparator {
    PRICE((room1, room2) -> Double.compare(room1.getPrice(), room2.getPrice())),
    PLACE_AMOUNT((room1, room2) -> room1.getPlaceAmount() - room2.getPlaceAmount());

    private final Comparator<Room> comparator;

    RoomComparator(Comparator<Room> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Room> getComparator() {
        return comparator;
    }
}
