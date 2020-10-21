package by.epam.project.util;

import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.*;

public class DateUtilTest {

    @Test
    public void parseDateToStringFormatShouldParseCorrect() {
        String expectedStringFormat = "2021-10-23";
        String actualStringFormat = DateUtil.parseDateToStringFormat(new Date(1634936400000L));
    }

    @Test
    public void parseDateToMillisecondsShouldParseCorrect() {
        long expectedMilliseconds = 1634936400000L;
        long actualMilliseconds = DateUtil.parseDateToMilliseconds(new Date(1634936400000L));
        assertEquals(expectedMilliseconds, actualMilliseconds);
    }

    @Test
    public void parseDateStringToMillisecondsShouldParseCorrect() {
        long expectedMilliseconds = 1634936400000L;
        long actualMilliseconds = DateUtil.parseDateStringToMilliseconds("2021-10-23");
        assertEquals(expectedMilliseconds, actualMilliseconds);
    }

    @Test
    public void parseDateStringToMillisecondsShouldParseIncorrect() {
        long expectedDefaultValue = -1;
        long actualDefaultValue = DateUtil.parseDateStringToMilliseconds("123");
        assertEquals(expectedDefaultValue, actualDefaultValue);
    }

    @Test
    public void parseMillisecondsToDateShouldParseCorrect() {
        long milliseconds = 1603054800000L;
        Date expectedDate = new Date(milliseconds);
        Date actualDate = DateUtil.parseMillisecondsToDate(milliseconds);
        assertEquals(expectedDate, actualDate);
    }
}
