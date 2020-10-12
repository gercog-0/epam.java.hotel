package by.epam.project.entity;

import java.util.Arrays;
import java.util.Optional;

public class Room extends Entity {
    public enum Comfort {
        ECONOMY("economy"),
        STANDARD("standard"),
        LUXURY("luxury"),
        APARTMENTS("apartments");

        private final String name;

        Comfort(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

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

    public Room(int roomId, int number, Comfort comfort, double price, boolean isActive, int placeAmount) {
        this.roomId = roomId;
        this.number = number;
        this.comfort = comfort;
        this.price = price;
        this.isActive = isActive;
        this.placeAmount = placeAmount;
    }

    public Room(int number, Comfort comfort, double price, boolean isActive, int placeAmount) {
        this.number = number;
        this.comfort = comfort;
        this.price = price;
        this.isActive = isActive;
        this.placeAmount = placeAmount;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Comfort getComfort() {
        return comfort;
    }

    public void setComfort(Comfort comfort) {
        this.comfort = comfort;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getPlaceAmount() {
        return placeAmount;
    }

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
