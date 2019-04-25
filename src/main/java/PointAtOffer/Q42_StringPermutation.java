package PointAtOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q42_StringPermutation {

    public static List<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) return res;

        char[] chars = str.toCharArray();
        // No duplicate char
        Arrays.sort(chars);
        backtracking(chars, res, new boolean[chars.length], new StringBuilder());
        return res;
    }

    private static void backtracking(final char[] chars, final List<String> res, final boolean[] marked, StringBuilder str) {
        if (str.length() == chars.length) {
            res.add(str.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (marked[i]) continue;
            // No duplicate char
            if (i != 0 && chars[i] == chars[i - 1] && !marked[i - 1]) continue;
            marked[i] = true;
            str.append(chars[i]);
            backtracking(chars, res, marked, str);
            str.deleteCharAt(str.length() - 1);
            marked[i] = false;
        }
    }
}
