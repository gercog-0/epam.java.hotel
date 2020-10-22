package by.epam.project.model.service;

import by.epam.project.exception.ServiceException;
import by.epam.project.model.entity.Room;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * The interface Room service.
 */
public interface RoomService {
    /**
     * Find by number optional.
     *
     * @param roomNumber the room number
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<Room> findByNumber(String roomNumber) throws ServiceException;

    /**
     * Sort by parameter list.
     *
     * @param freeRooms the free rooms
     * @param sortType  the sort type
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Room> sortByParameter(List<Room> freeRooms, String sortType) throws ServiceException;

    /**
     * Find free rooms by parameters list.
     *
     * @param comfort     the comfort
     * @param placeAmount the place amount
     * @param from        the from
     * @param to          the to
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Room> findFreeRoomsByParameters(String comfort, String placeAmount, String from, String to)
            throws ServiceException;

    /**
     * Find all rooms list.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Room> findAllRooms() throws ServiceException;

    /**
     * Add room boolean.
     *
     * @param room the room
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean addRoom(Room room) throws ServiceException;

    /**
     * Activate room boolean.
     *
     * @param number the number
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean activateRoom(String number) throws ServiceException;

    /**
     * Inactivate room boolean.
     *
     * @param number the number
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean inactivateRoom(String number) throws ServiceException;

}
