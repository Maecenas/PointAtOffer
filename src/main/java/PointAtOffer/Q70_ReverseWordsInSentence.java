package PointAtOffer;

public class Q70_ReverseWordsInSentence {

    public static String reverse(String str) {
        if (str == null || str.length() <= 1) return str;

        int n = str.length();
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);

        int start = 0, end = 0;
        while (end <= n) {
            if (end == n || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
            end++;
        }
        return String.valueOf(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start++, end--);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
