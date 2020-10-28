package by.epam.project.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * The type Date util.
 */
public class DateUtil {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final long INCORRECT_DEFAULT_RETURN_VALUE = -1L;

    private DateUtil() {
    }

    /**
     * Take current date format date.
     *
     * @return the date
     */
    public static Date takeCurrentDateFormat() {
        Date currentDate = new Date();
        String currentDateFormat = DATE_FORMAT.format(currentDate);
        Optional<Date> currentDateOptional = parseStringToDateFormat(currentDateFormat);
        return currentDateOptional.orElse(currentDate);
    }


    /**
     * Parse string to date format optional.
     *
     * @param dateString the date string
     * @return the optional
     */
    public static Optional<Date> parseStringToDateFormat(String dateString) {
        Optional<Date> dateFormat;
        try {
            Date date = DATE_FORMAT.parse(dateString);
            dateFormat = Optional.of(date);
        } catch (ParseException exp) {
            dateFormat = Optional.empty();
        }
        return dateFormat;
    }

    /**
     * Parse date to string format string.
     *
     * @param date the date
     * @return the string
     */
    public static String parseDateToStringFormat(Date date) {
        String stringFormat = DATE_FORMAT.format(date);
        return stringFormat;
    }

    /**
     * Parse date to milliseconds long.
     *
     * @param date the date
     * @return the long
     */
    public static long parseDateToMilliseconds(Date date) {
        long milliseconds = date.getTime();
        return milliseconds;
    }

    /**
     * Parse date string to milliseconds long.
     *
     * @param dateString the date string
     * @return the long
     */
    public static long parseDateStringToMilliseconds(String dateString) {
        try {
            Date dateFormat = DATE_FORMAT.parse(dateString);
            long milliseconds = dateFormat.getTime();
            return milliseconds;
        } catch (ParseException exp) {
            return INCORRECT_DEFAULT_RETURN_VALUE;
        }
    }

    /**
     * Parse milliseconds to date date.
     *
     * @param milliseconds the milliseconds
     * @return the date
     */
    public static Date parseMillisecondsToDate(long milliseconds) {
        Date date = new Date(milliseconds);
        return date;
    }
}
