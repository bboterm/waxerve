package nl.daraja.waxerve.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public final class I18n {
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("messages", Locale.getDefault());

    // Prevents accidental instantiation
    private I18n() {}

    public static String get(String key, Object... args) {
        String template = BUNDLE.getString(key);
        return MessageFormat.format(template, args);
    }
}
