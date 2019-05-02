package PointAtOffer;

import java.util.Arrays;

public class Q54_LongestSubstringWithoutDup {

    public static int longestSubstringWithoutDup(String str) {
        if (str == null) return 0;
        if (str.length() <= 1) return str.length();

        char[] chars = str.toCharArray();
        int[] p = new int[256];
        Arrays.fill(p, -1);

        int res = 0, left = -1;
        for (int i = 0; i < str.length(); i++) {
            left = Math.max(left, p[chars[i]]);
            p[chars[i]] = i;
            res = Math.max(res, i - left);
        }
        return res;
    }
}
