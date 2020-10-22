package by.epam.project.model.entity;

import java.util.Arrays;
import java.util.Optional;

/**
 * The type Room.
 */
public class Room extends Entity {
    /**
     * The enum Comfort.
     */
    public enum Comfort {
        /**
         * Economy comfort.
         */
        ECONOMY("economy"),
        /**
         * Standard comfort.
         */
        STANDARD("standard"),
        /**
         * Luxury comfort.
         */
        LUXURY("luxury"),
        /**
         * Apartments comfort.
         */
        APARTMENTS("apartments");

        private final String name;

        Comfort(String name) {
            this.name = name;
        }

        /**
         * Gets name.
         *
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * Gets comfort type by value.
         *
         * @param value the value
         * @return the comfort type by value
         */
        public static Optional<Comfort> getComfortTypeByValue(String value) {
            return Arrays.stream(Comfort.values()).
                    filter(o -> o.getName().equals(value)).findAny();
        }
    }

    private int roomId;
    private int number;
    private Comfort comfort;
    private double price;
    private boolean isActive;
    private int placeAmount;

    /**
     * Instantiates a new Room.
     *
     * @param roomId      the room id
     * @param number      the number
     * @param comfort     the comfort
     * @param price       the price
     * @param isActive    the is active
     * @param placeAmount the place amount
     */
    public Room(int roomId, int number, Comfort comfort, double price, boolean isActive, int placeAmount) {
        this.roomId = roomId;
        this.number = number;
        this.comfort = comfort;
        this.price = price;
        this.isActive = isActive;
        this.placeAmount = placeAmount;
    }

    /**
     * Instantiates a new Room.
     *
     * @param number      the number
     * @param comfort     the comfort
     * @param price       the price
     * @param isActive    the is active
     * @param placeAmount the place amount
     */
    public Room(int number, Comfort comfort, double price, boolean isActive, int placeAmount) {
        this.number = number;
        this.comfort = comfort;
        this.price = price;
        this.isActive = isActive;
        this.placeAmount = placeAmount;
    }

    /**
     * Gets room id.
     *
     * @return the room id
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * Sets room id.
     *
     * @param roomId the room id
     */
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    /**
     * Gets number.
     *
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets number.
     *
     * @param number the number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Gets comfort.
     *
     * @return the comfort
     */
    public Comfort getComfort() {
        return comfort;
    }

    /**
     * Sets comfort.
     *
     * @param comfort the comfort
     */
    public void setComfort(Comfort comfort) {
        this.comfort = comfort;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Is active boolean.
     *
     * @return the boolean
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Sets active.
     *
     * @param active the active
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Gets place amount.
     *
     * @return the place amount
     */
    public int getPlaceAmount() {
        return placeAmount;
    }

    /**
     * Sets place amount.
     *
     * @param placeAmount the place amount
     */
    public void setPlaceAmount(int placeAmount) {
        this.placeAmount = placeAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Room room = (Room) o;

        if (roomId != room.roomId) {
            return false;
        }
        if (number != room.number) {
            return false;
        }
        if (Double.compare(room.price, price) != 0) {
            return false;
        }
        if (isActive != room.isActive) {
            return false;
        }
        if (placeAmount != room.placeAmount) {
            return false;
        }
        return comfort == room.comfort;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = roomId;
        result = 31 * result + number;
        result = 31 * result + (comfort != null ? comfort.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + placeAmount;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Room{");
        sb.append("roomId=").append(roomId);
        sb.append(", number=").append(number);
        sb.append(", comfort=").append(comfort);
        sb.append(", price=").append(price);
        sb.append(", isActive=").append(isActive);
        sb.append(", placeAmount=").append(placeAmount);
        sb.append('}');
        return sb.toString();
    }
}
