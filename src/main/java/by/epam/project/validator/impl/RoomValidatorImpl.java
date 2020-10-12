package by.epam.project.validator.impl;

import by.epam.project.entity.Room;
import by.epam.project.validator.BaseValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static by.epam.project.util.RequestParameter.*;

public class RoomValidatorImpl implements BaseValidator {
    private static final String PRICE_REGEX = "^\\d+\\.?\\d+$";
    private static final String COMFORT_REGEX = "^[a-zA-z]+$";
    private static final String PLACE_AMOUNT_REGEX = "^\\d$";
    private static final String IS_ACTIVE_REGEX_TRUE = "^true$";
    private static final String IS_ACTIVE_REGEX_FALSE = "^false$";
    private static final double MIN_PRICE = 150;
    private static final double MAX_PRICE = 15000;
    private static final int MIN_PLACE_AMOUNT = 1;
    private static final int MAX_PLACE_AMOUNT = 5;

    private static final RoomValidatorImpl instance = new RoomValidatorImpl();

    private RoomValidatorImpl() {
    }

    public static RoomValidatorImpl getInstance() {
        return instance;
    }

    public Map<String, String> validateParameters(String comfort, String price, String placeAmount, String isActive) {
        Map<String, String> validatedData = new HashMap<>();
        validatedData.put(ROOM_COMFORT, isComfortTypeCorrect(comfort) ? comfort : EMPTY_STRING);
        validatedData.put(ROOM_PRICE, isPriceCorrect(price) ? price : EMPTY_STRING);
        validatedData.put(ROOM_PLACE_AMOUNT, isPlaceAmountCorrect(placeAmount) ? placeAmount : EMPTY_STRING);
        validatedData.put(ROOM_IS_ACTIVE, isActiveCorrect(isActive) ? isActive : EMPTY_STRING);
        return validatedData;
    }

    public boolean isPlaceAmountCorrect(String placeAmount) {
        if (isStringMatches(placeAmount, PLACE_AMOUNT_REGEX)) {
            int places = Integer.parseInt(placeAmount);
            if (MIN_PLACE_AMOUNT <= places && places <= MAX_PLACE_AMOUNT) {
                return true;
            }
        }
        return false;
    }


    public boolean isComfortTypeCorrect(String comfort) {
        if (isStringMatches(comfort, COMFORT_REGEX)) {
            Optional<Room.Comfort> comfortType = Room.Comfort.getComfortTypeByValue(comfort);
            if (comfortType.isPresent()) {
                return true;
            }
        }
        return false;
    }

    public boolean isActiveCorrect(String isActive) {
        if (isStringMatches(isActive, IS_ACTIVE_REGEX_TRUE)
                || isStringMatches(isActive, IS_ACTIVE_REGEX_FALSE)) {
            return true;
        }
        return false;
    }

    public boolean isPriceCorrect(String price) {
        if (isStringMatches(price, PRICE_REGEX)) {
            double value = Double.parseDouble(price);
            if (MIN_PRICE <= value && value <= MAX_PRICE) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean defineIncorrectValues(Map<String, String> data) {
        for (String key : data.keySet()) {
            if (data.get(key).isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
