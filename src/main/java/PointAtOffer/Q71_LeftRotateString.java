package PointAtOffer;

import static PointAtOffer.Q70_ReverseWordsInSentence.reverse;

public class Q71_LeftRotateString {

    public static String leftRotateString(String str, int n) {
        if (str == null || n < 0 || str.length() <= n) return str;
        // assert n < 0;

        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, str.length() - 1);
        reverse(chars, 0, str.length() - 1);
        return String.valueOf(chars);
    }
}
