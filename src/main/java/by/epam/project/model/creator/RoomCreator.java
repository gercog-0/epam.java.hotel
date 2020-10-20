package by.epam.project.model.creator;

import by.epam.project.entity.Room;

import java.util.Optional;

public class RoomCreator {
    private static RoomCreator instance = new RoomCreator();
    private static boolean DEFAULT_ROOM_STATUS = true;

    private RoomCreator() {
    }

    public static RoomCreator getInstance() {
        return instance;
    }

    public Room createRoom(int roomId, int roomNumber, Room.Comfort roomComfort,
                           double roomPrice, int roomPlaceAmount, boolean isActive) {
        Room room = new Room(roomId, roomNumber, roomComfort, roomPrice, isActive, roomPlaceAmount);
        return room;
    }

    public Room createRoom(String roomNumberString, String roomComfortString,
                           String placeAmountString, String roomPriceString) {
        int roomNumber = Integer.parseInt(roomNumberString);
        Room.Comfort roomComfort = Room.Comfort.valueOf(roomComfortString.toUpperCase());
        int placeAmount = Integer.parseInt(placeAmountString);
        double roomPrice = Double.parseDouble(roomPriceString);
        Room room = new Room(roomNumber, roomComfort, roomPrice, DEFAULT_ROOM_STATUS, placeAmount);
        return room;
    }
}
