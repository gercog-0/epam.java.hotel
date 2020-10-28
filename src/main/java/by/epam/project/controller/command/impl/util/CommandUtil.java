package by.epam.project.controller.command.impl.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The type Command util.
 */
public class CommandUtil {
    private CommandUtil() {
    }

    private static final String RESOURCES_LANGUAGE = "pagecontent.language";
    private static final String ENGLISH_LANGUAGE = "en";
    private static final Locale DEFAULT_LANGUAGE = new Locale(ENGLISH_LANGUAGE);

    /**
     * Make part with locale string.
     *
     * @param language the language
     * @param key      the key
     * @return the string
     */
    public static String makePartWithLocale(String language, String key) {
        Locale currentLocale = DEFAULT_LANGUAGE;
        if (language != null) {
            currentLocale = new Locale(language);
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCES_LANGUAGE, currentLocale);
        return resourceBundle.getString(key);
    }
}
