package by.epam.project.util;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EncryptPasswordTest {
    @Test
    public void encryptionShouldEncryptCorrect(){
        String expectedEncryptedPassword = "827ccb0eea8a706c4c34a16891f84e7b";
        String actualEncryptPassword = EncryptPassword.encryption("12345");
        assertEquals(expectedEncryptedPassword, actualEncryptPassword);
    }

    @Test
    public void encryptionShouldEncryptIncorrect(){
        String expectedEncryptedPassword = "ccb0eea8a706c4c34a16891f84e7b";
        String actualEncryptPassword = EncryptPassword.encryption("12345");
        assertNotEquals(expectedEncryptedPassword, actualEncryptPassword);
    }
}
