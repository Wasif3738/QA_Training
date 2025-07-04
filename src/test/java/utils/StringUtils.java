package utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

    private static final String ONLY_DIGITS_REGEX = "[^0-9]";

    public static int extractLastNumber(String text) {
        String digitsOnly = text.replaceAll(ONLY_DIGITS_REGEX, "");
        return Integer.parseInt(digitsOnly);
    }
}
