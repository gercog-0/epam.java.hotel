package by.epam.project.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private DateUtil() {
    }

    public static long parseDateToMilliseconds(String dateString) throws ParseException {
        Date dateFormat = DATE_FORMAT.parse(dateString);
        long milliseconds = dateFormat.getTime();
        return milliseconds;
    }

    public static Date parseMillisecondsToDate(long milliseconds) throws ParseException {
        Date date = null;
        return date;
    }
}
