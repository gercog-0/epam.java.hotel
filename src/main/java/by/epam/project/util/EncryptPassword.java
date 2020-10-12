package by.epam.project.util;

import org.apache.commons.codec.digest.DigestUtils;

public class EncryptPassword {
    private EncryptPassword() {
    }

    public static String encryption(String password) {
        String encryptPassword = DigestUtils.md5Hex(password);
        return encryptPassword;
    }
}
