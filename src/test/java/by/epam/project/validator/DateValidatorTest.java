package by.epam.project.validator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/*
       IMPORTANT
       When checking a test for its successful completion,
       the current date is used for comparison with the passed parameters
 */

public class DateValidatorTest {
    @DataProvider(name = "correctTestDate")
    public Object[][] returnCorrectDateToCheck() {
        return new Object[][]{
                {"2021-02-12", "2021-03-15"},
                {"2022-01-25", "2022-01-27"},
                {"2022-04-14", "2022-04-30"},
                {"2020-12-20", "2020-12-25"},
                {"2020-11-03", "2021-11-03"},
        };
    }

    @DataProvider(name = "incorrectTestDate")
    public Object[][] returnIncorrectDateToCheck() {
        return new Object[][]{
                {"2021-02-12", "2020-03-15"},
                {"2022-21-25", "2022-01-27"},
                {"2000-04-14", "2022-0-32"},
                {"2020-11-17", "2022-122-25"},
                {"202011-03", "2021-11-03"},
        };
    }

    @Test(dataProvider = "correctTestDate")
    public void checkDataReturnTrue(String arrivalDate, String departureDate) {
        boolean condition = DateValidator.checkDate(arrivalDate, departureDate);
        assertTrue(condition);
    }

    @Test(dataProvider = "incorrectTestDate")
    public void checkDataReturnFalse(String arrivalDate, String departureDate) {
        boolean condition = DateValidator.checkDate(arrivalDate, departureDate);
        assertFalse(condition);
    }

    @Test
    public void isYearCorrectReturnTrue(){
        boolean condition = DateValidator.isYearCorrect(2022);
        assertTrue(condition);
    }

    @Test
    public void isYearCorrectReturnFalse(){
        boolean condition = DateValidator.isYearCorrect(200);
        assertFalse(condition);
    }

    @Test
    public void isMonthCorrectReturnTrue(){
        boolean condition = DateValidator.isMonthCorrect(11);
        assertTrue(condition);
    }

    @Test
    public void isMonthCorrectReturnFalse(){
        boolean condition = DateValidator.isMonthCorrect(-12);
        assertFalse(condition);
    }
    @Test
    public void isDayCorrectReturnTrue(){
        boolean condition = DateValidator.isDayCorrect(6);
        assertTrue(condition);
    }

    @Test
    public void isDayCorrectReturnFalse(){
        boolean condition = DateValidator.isDayCorrect(35);
        assertFalse(condition);
    }
}
