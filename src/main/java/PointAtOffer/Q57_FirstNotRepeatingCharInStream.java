package PointAtOffer;

import java.util.Arrays;

public class Q57_FirstNotRepeatingCharInStream {

    private static final int R = 256;
    private static int[] counts;
    private static int index;

    public Q57_FirstNotRepeatingCharInStream() {
        index = 0;
        counts = new int[R];
        Arrays.fill(counts, -1);
    }

    public static void insert(char c) {
        if (counts[c] == -1) {
            counts[c] = index;
        } else {
            counts[c] = -2;
        }
        index++;
    }

    public static char find() {
        int minIndex = R;
        char res = '\0';
        for (int i = 0; i < R; i++) {
            if (counts[i] >= 0 && counts[i] < minIndex) {
                minIndex = counts[i];
                res = (char) i;
            }
        }
        return res;
    }
}
