package by.epam.project.util.comparator;

import by.epam.project.model.entity.Room;

import java.util.Comparator;

/**
 * The enum Room comparator.
 */
public enum RoomComparator {
    /**
     * Price room comparator.
     */
    PRICE((room1, room2) -> Double.compare(room1.getPrice(), room2.getPrice())),
    /**
     * Place amount room comparator.
     */
    PLACE_AMOUNT((room1, room2) -> room1.getPlaceAmount() - room2.getPlaceAmount());

    private final Comparator<Room> comparator;

    RoomComparator(Comparator<Room> comparator) {
        this.comparator = comparator;
    }

    /**
     * Gets comparator.
     *
     * @return the comparator
     */
    public Comparator<Room> getComparator() {
        return comparator;
    }
}
