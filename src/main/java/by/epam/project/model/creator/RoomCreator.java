package by.epam.project.model.creator;

import by.epam.project.model.entity.Room;

/**
 * The type Room creator.
 */
public class RoomCreator {
    private static RoomCreator instance = new RoomCreator();
    private static boolean DEFAULT_ROOM_STATUS = true;

    private RoomCreator() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static RoomCreator getInstance() {
        return instance;
    }

    /**
     * Create room room.
     *
     * @param roomId          the room id
     * @param roomNumber      the room number
     * @param roomComfort     the room comfort
     * @param roomPrice       the room price
     * @param roomPlaceAmount the room place amount
     * @param isActive        the is active
     * @return the room
     */
    public Room createRoom(int roomId, int roomNumber, Room.Comfort roomComfort,
                           double roomPrice, int roomPlaceAmount, boolean isActive) {
        Room room = new Room(roomId, roomNumber, roomComfort, roomPrice, isActive, roomPlaceAmount);
        return room;
    }

    /**
     * Create room room.
     *
     * @param roomNumberString  the room number string
     * @param roomComfortString the room comfort string
     * @param placeAmountString the place amount string
     * @param roomPriceString   the room price string
     * @return the room
     */
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
