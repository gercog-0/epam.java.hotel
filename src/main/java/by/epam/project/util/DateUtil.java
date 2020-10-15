package by.epam.project.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class DateUtil {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final int INCORRECT_DEFAULT_RETURN_VALUE = -1;

    private DateUtil() {
    }

    public static Date takeCurrentDateFormat() {
        Date currentDate = new Date();
        String currentDateFormat = DATE_FORMAT.format(currentDate);
        Optional<Date> currentDateOptional = parseStringToDateFormat(currentDateFormat);
        return currentDateOptional.orElse(currentDate);
    }


    public static Optional<Date> parseStringToDateFormat(String dateString) {
        Optional<Date> dateFormat;
        try {
            dateFormat = Optional.of(DATE_FORMAT.parse(dateString));
        } catch (ParseException exp) {
            dateFormat = Optional.empty();
        }
        return dateFormat;
    }

    public static long parseDateToMilliseconds(Date date) {
        long milliseconds = date.getTime();
        return milliseconds;
    }

    public static long parseDateStringToMilliseconds(String dateString) {
        try {
            Date dateFormat = DATE_FORMAT.parse(dateString);
            long milliseconds = dateFormat.getTime();
            return milliseconds;
        } catch (ParseException exp) {
            return INCORRECT_DEFAULT_RETURN_VALUE;
        }
    }

    public static Date parseMillisecondsToDate(long milliseconds) {
        Date date = new Date(milliseconds);
        String dateStringFormat = DATE_FORMAT.format(date);
        Optional<Date> dateFormat = parseStringToDateFormat(dateStringFormat);
        return date;
    }
}
