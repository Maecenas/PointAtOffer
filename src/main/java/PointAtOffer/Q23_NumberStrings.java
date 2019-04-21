package PointAtOffer;

import java.util.regex.Pattern;

public class Q23_NumberStrings {

    private static final Pattern numeric = Pattern.compile("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");

    public static boolean isNumericRegEx(String str) {
        if (str == null || str.length() == 0) return false;

        return numeric.matcher(str).matches();
    }
}
