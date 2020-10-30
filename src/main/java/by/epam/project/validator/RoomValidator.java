package by.epam.project.validator;

import by.epam.project.model.entity.Room;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.epam.project.util.RequestParameterName.*;

/**
 * The type Room validator.
 */
public class RoomValidator {
    private static final String ROOM_NUMBER_REGEX = "^\\d{3}$";
    private static final String PRICE_REGEX = "^\\d+\\.?\\d+$";
    private static final String COMFORT_REGEX = "^[a-zA-z]+$";
    private static final String PLACE_AMOUNT_REGEX = "^\\d$";
    private static final String EMPTY_STRING = "";
    private static final double MIN_PRICE = 150;
    private static final double MAX_PRICE = 15000;
    private static final int MIN_PLACE_AMOUNT = 1;
    private static final int MAX_PLACE_AMOUNT = 5;
    private static final int MIN_ROOM_NUMBER = 100;
    private static final int MAX_ROOM_NUMBER = 500;

    private RoomValidator() {
    }

    /**
     * Validate parameters map.
     *
     * @param comfort     the comfort
     * @param price       the price
     * @param placeAmount the place amount
     * @param roomNumber  the room number
     * @return the map
     */
    public static Map<String, String> validateParameters(String comfort, String price,
                                                         String placeAmount, String roomNumber) {
        Map<String, String> validatedData = new HashMap<>();
        validatedData.put(ROOM_NUMBER, isRoomNumberCorrect(roomNumber) ? roomNumber : EMPTY_STRING);
        validatedData.put(ROOM_COMFORT, isComfortTypeCorrect(comfort) ? comfort : EMPTY_STRING);
        validatedData.put(ROOM_PRICE, isPriceCorrect(price) ? price : EMPTY_STRING);
        validatedData.put(ROOM_PLACE_AMOUNT, isPlaceAmountCorrect(placeAmount) ? placeAmount : EMPTY_STRING);
        return validatedData;
    }

    /**
     * Is room number correct boolean.
     *
     * @param roomNumber the room number
     * @return the boolean
     */
    public static boolean isRoomNumberCorrect(String roomNumber) {
        if (isEmptyOrNull(roomNumber) && isStringMatches(roomNumber, ROOM_NUMBER_REGEX)) {
            int number = Integer.parseInt(roomNumber);
            if (MIN_ROOM_NUMBER <= number && number <= MAX_ROOM_NUMBER) {
                return true;
            }
        }
        return false;
    }

    /**
     * Is place amount correct boolean.
     *
     * @param placeAmount the place amount
     * @return the boolean
     */
    public static boolean isPlaceAmountCorrect(String placeAmount) {
        if (isEmptyOrNull(placeAmount) && isStringMatches(placeAmount, PLACE_AMOUNT_REGEX)) {
            int places = Integer.parseInt(placeAmount);
            if (MIN_PLACE_AMOUNT <= places && places <= MAX_PLACE_AMOUNT) {
                return true;
            }
        }
        return false;
    }


    /**
     * Is comfort type correct boolean.
     *
     * @param comfort the comfort
     * @return the boolean
     */
    public static boolean isComfortTypeCorrect(String comfort) {
        if (isEmptyOrNull(comfort) && isStringMatches(comfort, COMFORT_REGEX)) {
            Optional<Room.Comfort> comfortType = Room.Comfort.getComfortTypeByValue(comfort.toLowerCase());
            if (comfortType.isPresent()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Is price correct boolean.
     *
     * @param price the price
     * @return the boolean
     */
    public static boolean isPriceCorrect(String price) {
        if (isEmptyOrNull(price) && isStringMatches(price, PRICE_REGEX)) {
            double value = Double.parseDouble(price);
            if (MIN_PRICE <= value && value <= MAX_PRICE) {
                return true;
            }
        }
        return false;
    }

    /**
     * Define incorrect values boolean.
     *
     * @param data the data
     * @return the boolean
     */
    public static boolean defineIncorrectValues(Map<String, String> data) {
        for (String key : data.keySet()) {
            if (data.get(key).isEmpty() || data.get(key).equals(NOT_UNIQUE)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isStringMatches(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    private static boolean isEmptyOrNull(String string) {
        return string != null && !string.isEmpty();
    }
}
