package by.epam.project.validator;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static by.epam.project.util.RequestParameterName.*;
import static org.testng.Assert.*;
import static org.testng.Assert.assertFalse;

public class RoomValidatorTest {
    private Map<String, String>[] correctMaps;
    private Map<String, String>[] incorrectMaps;

    @BeforeClass
    public void setUp() {
        correctMaps = new Map[3];
        Map<String, String> correctMapFirst = new HashMap<>();
        correctMapFirst.put(ROOM_NUMBER, "333");
        correctMapFirst.put(ROOM_COMFORT, "economy");
        correctMapFirst.put(ROOM_PRICE, "4000");
        correctMapFirst.put(ROOM_PLACE_AMOUNT, "3");
        Map<String, String> correctMapSecond = new HashMap<>();
        correctMapSecond.put(ROOM_NUMBER, "444");
        correctMapSecond.put(ROOM_COMFORT, "standard");
        correctMapSecond.put(ROOM_PRICE, "2000.30");
        correctMapSecond.put(ROOM_PLACE_AMOUNT, "4");
        Map<String, String> correctMapThird = new HashMap<>();
        correctMapThird.put(ROOM_NUMBER, "500");
        correctMapThird.put(ROOM_COMFORT, "luxury");
        correctMapThird.put(ROOM_PRICE, "7500.50");
        correctMapThird.put(ROOM_PLACE_AMOUNT, "1");

        correctMaps[0] = correctMapFirst;
        correctMaps[1] = correctMapSecond;
        correctMaps[2] = correctMapThird;

        incorrectMaps = new Map[3];
        Map<String, String> incorrectMapFirst = new HashMap<>();
        incorrectMapFirst.put(ROOM_NUMBER, "");
        incorrectMapFirst.put(ROOM_COMFORT, "economy");
        incorrectMapFirst.put(ROOM_PRICE, "1");
        incorrectMapFirst.put(ROOM_PLACE_AMOUNT, "3");
        Map<String, String> incorrectMapSecond = new HashMap<>();
        incorrectMapSecond.put(ROOM_NUMBER, "444");
        incorrectMapSecond.put(ROOM_COMFORT, "simple");
        incorrectMapSecond.put(ROOM_PRICE, "2000.30");
        incorrectMapSecond.put(ROOM_PLACE_AMOUNT, "");
        Map<String, String> incorrectMapThird = new HashMap<>();
        incorrectMapThird.put(ROOM_NUMBER, "500");
        incorrectMapThird.put(ROOM_COMFORT, "");
        incorrectMapThird.put(ROOM_PRICE, "7500222.50");
        incorrectMapThird.put(ROOM_PLACE_AMOUNT, "1");

        incorrectMaps[0] = incorrectMapFirst;
        incorrectMaps[1] = incorrectMapSecond;
        incorrectMaps[2] = incorrectMapThird;
    }

    @DataProvider(name = "correctMaps")
    public Object[] returnCorrectMap() {
        return new Object[]{
                correctMaps[0],
                correctMaps[1],
                correctMaps[2],
        };
    }

    @DataProvider(name = "incorrectMaps")
    public Object[] returnIncorrectMap() {
        return new Object[]{
                incorrectMaps[0],
                incorrectMaps[1],
                incorrectMaps[2],
        };
    }

    @DataProvider(name = "correctDataToValidateParameters")
    public Object[][] returnCorrectDataToValidateParameters() {
        return new Object[][]{
                {correctMaps[0], "economy", "4000", "3", "333"},
                {correctMaps[1], "standard", "2000.30", "4", "444"},
                {correctMaps[2], "luxury", "7500.50", "1", "500"},
        };
    }

    @DataProvider(name = "incorrectDataToValidateParameters")
    public Object[][] returnIncorrectDataToValidateParameters() {
        return new Object[][]{
                {incorrectMaps[0], "economy", "1", "3", ""},
                {incorrectMaps[1], "simple", "2000.30", "", "444"},
                {incorrectMaps[2], "", "7500222.50", "1", "565"},
        };
    }

    @Test(dataProvider = "correctDataToValidateParameters")
    public void validateParametersCorrectMapsEquals(Map<String, String> correctMap, String comfort, String price,
                                                    String placeAmount, String roomNumber) {
        Map<String, String> actualMap = RoomValidator.validateParameters(comfort, price, placeAmount, roomNumber);
        assertEquals(correctMap, actualMap);
    }

    @Test(dataProvider = "incorrectDataToValidateParameters")
    public void validateParametersIncorrectMapsNotEquals(Map<String, String> correctMap, String comfort, String price,
                                                         String placeAmount, String roomNumber) {
        Map<String, String> actualMap = RoomValidator.validateParameters(comfort, price, placeAmount, roomNumber);
        assertNotEquals(correctMap, actualMap);
    }

    @Test(dataProvider = "correctMaps")
    public void defineIncorrectValuesReturnTrue(Map<String, String> currentMap) {
        boolean condition = RoomValidator.defineIncorrectValues(currentMap);
        assertTrue(condition);

    }

    @Test(dataProvider = "incorrectMaps")
    public void defineIncorrectValuesReturnFalse(Map<String, String> currentMap) {
        boolean condition = RoomValidator.defineIncorrectValues(currentMap);
        assertFalse(condition);
    }

    @AfterClass
    public void tierDown() {
        correctMaps = null;
        incorrectMaps = null;
    }
}
