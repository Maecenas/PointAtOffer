package PointAtOffer;

import java.util.BitSet;

public class Q56_FirstNotRepeatingChar {

    private static final int R = 256;

    public static int firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;

        final char[] chars = str.toCharArray();
        int[] counts = new int[R];
        for (int i = 0; i < str.length(); i++) {
            counts[chars[i]]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (counts[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Using two bits to store (0, 1, else) states
     */
    public static int firstNotRepeatingCharBitSet(String str) {
        if (str == null || str.length() == 0) return -1;

        final char[] chars = str.toCharArray();
        BitSet bs1 = new BitSet(R);
        BitSet bs2 = new BitSet(R);
        for (char c : chars) {
            if (!bs1.get(c) && !bs2.get(c)) {
                bs1.set(c);  // 0 0 -> 0 1
            } else if (bs1.get(c) && !bs2.get(c)) {
                bs2.set(c);  // 0 1 -> 1 1
            } else {
                // 1 1
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = chars[i];
            if (bs1.get(c) && !bs2.get(c)) {
                return i;  // 0 1
            }
        }
        return -1;
    }
}
