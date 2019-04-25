package PointAtOffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q42_StringPermutation {

    public static List<String> permutation(String str) {
        if (str == null || str.length() == 0) return new ArrayList<>(0);

        Set<String> res = new HashSet<>();
        char[] chars = str.toCharArray();
        backtracking(chars, res, new boolean[chars.length], new StringBuilder());
        return new ArrayList<>(res);
    }

    private static void backtracking(final char[] chars, final Set<String> res, final boolean[] marked, StringBuilder str) {
        if (str.length() == chars.length) {
            res.add(str.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (marked[i]) continue;
            marked[i] = true;
            str.append(chars[i]);
            backtracking(chars, res, marked, str);
            str.deleteCharAt(str.length() - 1);
            marked[i] = false;
        }
    }
}
