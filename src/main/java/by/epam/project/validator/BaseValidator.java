package by.epam.project.validator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface BaseValidator {
    String EMPTY_STRING = "";

    boolean defineIncorrectValues(Map<String, String> data);

    default boolean isStringMatches(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    default boolean isEmptyOrNull(String string) {
        return string != null && !string.isEmpty();
    }
}
