package PointAtOffer;

public class Q82_StringToInt {

    public static int atoi(String str) {
        if (str == null || str.length() == 0) return 0;

        int index = 0, total = 0;

        // trim heading blank spaces
        while (str.charAt(index) == ' ') {
            index++;
            if (index == str.length()) return 0;
        }

        boolean isNonNegative = true;

        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            if (str.charAt(index++) == '-') {
                isNonNegative = false;
            }
        }

        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            // escape on invalid input
            if (digit < 0 || digit > 9) break;
            // Integer overflow and underflow
            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && digit > 7)) {
                return isNonNegative ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10 * total + digit;
            index++;
        }
        return isNonNegative ? total : -1 * total;
    }
}
