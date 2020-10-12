package by.epam.project.model.creator;

import by.epam.project.entity.Room;

import java.util.Optional;

public class RoomCreator {
    public static RoomCreator instance = new RoomCreator();

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
}
