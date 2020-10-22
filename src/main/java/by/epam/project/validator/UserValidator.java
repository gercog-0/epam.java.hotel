package by.epam.project.validator;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.epam.project.util.RequestParameterName.*;

/**
 * The type User validator.
 */
public class UserValidator {
    private static final String LOGIN_REGEX = "^[a-zA-Z0-9_]{3,25}$";
    private static final String PASSWORD_REGEX = "^.{3,25}$";
    private static final String EMAIL_REGEX = "^[a-zA-z0-9_.-]{1,35}@[a-zA-z0-9_-]{2,15}\\.[a-z]{2,5}$";
    private static final String NAME_REGEX = "^[a-zA-Z]{2,25}$";
    private static final String SURNAME_REGEX = "^[a-zA-Z]{2,25}$";
    private static final String PHONE_REGEX = "^(\\+375\\([\\d]{2}\\)[\\d]{3}\\-[\\d]{2}\\-[\\d]{2})$";
    private static final String EMPTY_STRING = "";

    private UserValidator() {
    }

    /**
     * Validate parameters map.
     *
     * @param login    the login
     * @param password the password
     * @param email    the email
     * @param name     the name
     * @param surname  the surname
     * @param phone    the phone
     * @return the map
     */
    public static Map<String, String> validateParameters(String login, String password
            , String email, String name, String surname, String phone) {
        Map<String, String> validatedData = new HashMap<>();
        validatedData.put(USER_LOGIN, isLoginCorrect(login) ? login : EMPTY_STRING);
        validatedData.put(USER_PASSWORD, isPasswordCorrect(password) ? password : EMPTY_STRING);
        validatedData.put(USER_EMAIL, isEmailCorrect(email) ? email : EMPTY_STRING);
        validatedData.put(USER_NAME, isNameCorrect(name) ? name : EMPTY_STRING);
        validatedData.put(USER_SURNAME, isSurnameCorrect(surname) ? surname : EMPTY_STRING);
        validatedData.put(USER_PHONE, isPhoneCorrect(phone) ? phone : EMPTY_STRING);

        return validatedData;
    }

    /**
     * Is login correct boolean.
     *
     * @param login the login
     * @return the boolean
     */
    public static boolean isLoginCorrect(String login) {
        return isEmptyOrNull(login) && isStringMatches(login, LOGIN_REGEX);
    }

    /**
     * Is password correct boolean.
     *
     * @param password the password
     * @return the boolean
     */
    public static boolean isPasswordCorrect(String password) {
        return isEmptyOrNull(password) && isStringMatches(password, PASSWORD_REGEX);
    }

    /**
     * Is email correct boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public static boolean isEmailCorrect(String email) {
        return isEmptyOrNull(email) && isStringMatches(email, EMAIL_REGEX);
    }

    /**
     * Is name correct boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public static boolean isNameCorrect(String name) {
        return isEmptyOrNull(name) && isStringMatches(name, NAME_REGEX);
    }

    /**
     * Is surname correct boolean.
     *
     * @param surname the surname
     * @return the boolean
     */
    public static boolean isSurnameCorrect(String surname) {
        return isEmptyOrNull(surname) && isStringMatches(surname, SURNAME_REGEX);
    }

    /**
     * Is phone correct boolean.
     *
     * @param phone the phone
     * @return the boolean
     */
    public static boolean isPhoneCorrect(String phone) {
        return isEmptyOrNull(phone) && isStringMatches(phone, PHONE_REGEX);
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

    private static boolean isEmptyOrNull(String string) {
        return string != null && !string.isEmpty();
    }

    private static boolean isStringMatches(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
