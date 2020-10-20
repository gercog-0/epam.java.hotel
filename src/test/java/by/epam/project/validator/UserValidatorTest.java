package by.epam.project.validator;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static by.epam.project.util.RequestParameterName.*;
import static org.testng.Assert.*;

public class UserValidatorTest {
    private Map<String, String>[] correctMaps;
    private Map<String, String>[] incorrectMaps;

    @BeforeClass
    public void setUp() {
        correctMaps = new Map[3];
        Map<String, String> correctMapFirst = new HashMap<>();
        correctMapFirst.put(USER_LOGIN, "gercog");
        correctMapFirst.put(USER_PASSWORD, "12345");
        correctMapFirst.put(USER_EMAIL, "ivan@mail.ru");
        correctMapFirst.put(USER_NAME, "Ivan");
        correctMapFirst.put(USER_SURNAME, "Yanushkevich");
        correctMapFirst.put(USER_PHONE, "+375(33)633-33-33");
        Map<String, String> correctMapSecond = new HashMap<>();
        correctMapSecond.put(USER_LOGIN, "luki4");
        correctMapSecond.put(USER_PASSWORD, "qwerty!");
        correctMapSecond.put(USER_EMAIL, "ivan_luki4@mail.ru");
        correctMapSecond.put(USER_NAME, "Ivan");
        correctMapSecond.put(USER_SURNAME, "Luk");
        correctMapSecond.put(USER_PHONE, "+375(29)622-31-31");
        Map<String, String> correctMapThird = new HashMap<>();
        correctMapThird.put(USER_LOGIN, "bond");
        correctMapThird.put(USER_PASSWORD, "bondarenko12345");
        correctMapThird.put(USER_EMAIL, "bond@gmail.com");
        correctMapThird.put(USER_NAME, "Eugene");
        correctMapThird.put(USER_SURNAME, "Bondarenko");
        correctMapThird.put(USER_PHONE, "+375(44)434-62-82");

        correctMaps[0] = correctMapFirst;
        correctMaps[1] = correctMapSecond;
        correctMaps[2] = correctMapThird;

        incorrectMaps = new Map[3];
        Map<String, String> incorrectMapFirst = new HashMap<>();
        incorrectMapFirst.put(USER_LOGIN, "gercog    1");
        incorrectMapFirst.put(USER_PASSWORD, "1");
        incorrectMapFirst.put(USER_EMAIL, "ivan@mail.ru");
        incorrectMapFirst.put(USER_NAME, "");
        incorrectMapFirst.put(USER_SURNAME, "Yanushkevich");
        incorrectMapFirst.put(USER_PHONE, "+375(33)633-33-33");
        Map<String, String> incorrectMapSecond = new HashMap<>();
        incorrectMapSecond.put(USER_LOGIN, "");
        incorrectMapSecond.put(USER_PASSWORD, "qwerty!");
        incorrectMapSecond.put(USER_EMAIL, "ivan_luki4@mail.ru");
        incorrectMapSecond.put(USER_NAME, "Ivan");
        incorrectMapSecond.put(USER_SURNAME, "Luk65");
        incorrectMapSecond.put(USER_PHONE, "+375(29)622-31-31");
        Map<String, String> incorrectMapThird = new HashMap<>();
        incorrectMapThird.put(USER_LOGIN, "bond");
        incorrectMapThird.put(USER_PASSWORD, "bondarenko12345");
        incorrectMapThird.put(USER_EMAIL, "bondgmail.com");
        incorrectMapThird.put(USER_NAME, "Eugene");
        incorrectMapThird.put(USER_SURNAME, "");
        incorrectMapThird.put(USER_PHONE, "+375(4)434-62-82");

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
                {correctMaps[0], "gercog", "12345", "ivan@mail.ru", "Ivan", "Yanushkevich", "+375(33)633-33-33"},
                {correctMaps[1], "luki4", "qwerty!", "ivan_luki4@mail.ru", "Ivan", "Luk", "+375(29)622-31-31"},
                {correctMaps[2], "bond", "bondarenko12345", "bond@gmail.com", "Eugene", "Bondarenko", "+375(44)434-62-82"},
        };
    }

    @DataProvider(name = "incorrectDataToValidateParameters")
    public Object[][] returnIncorrectDataToValidateParameters() {
        return new Object[][]{
                {incorrectMaps[0], "gercog    1", "12345", "ivan@mail.ru", "", "Yanushkevich", "+375(33)633-33-33"},
                {incorrectMaps[1], "", "qwerty!", "ivan_luki4@mail.ru", "Ivan", "Luk65", "+375(29)622-31-31"},
                {incorrectMaps[2], "bond", "bondarenko12345", "bond@gmail.com", "Eugene", "", "+375(4)434-62-82"},
        };
    }

    @Test(dataProvider = "correctDataToValidateParameters")
    public void validateParametersCorrectMapsEquals(Map<String, String> correctMap, String login, String password,
                                                    String email, String name, String surname, String phone) {
        Map<String, String> actualMap = UserValidator.validateParameters(login, password, email, name, surname, phone);
        assertEquals(correctMap, actualMap);
    }

    @Test(dataProvider = "incorrectDataToValidateParameters")
    public void validateParametersIncorrectMapsNotEquals(Map<String, String> correctMap, String login, String password,
                                                         String email, String name, String surname, String phone) {
        Map<String, String> actualMap = UserValidator.validateParameters(login, password, email, name, surname, phone);
        assertNotEquals(correctMap, actualMap);
    }

    @Test(dataProvider = "correctMaps")
    public void defineIncorrectValuesReturnTrue(Map<String, String> currentMap) {
        boolean condition = UserValidator.defineIncorrectValues(currentMap);
        assertTrue(condition);

    }

    @Test(dataProvider = "incorrectMaps")
    public void defineIncorrectValuesReturnFalse(Map<String, String> currentMap) {
        boolean condition = UserValidator.defineIncorrectValues(currentMap);
        assertFalse(condition);
    }

    @AfterClass
    public void tierDown() {
        correctMaps = null;
        incorrectMaps = null;
    }
}
