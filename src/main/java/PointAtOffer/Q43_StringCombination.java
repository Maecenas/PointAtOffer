package PointAtOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q43_StringCombination {

    public static List<String> combination(String str) {
        if (str == null || str.length() == 0) return new ArrayList<>();

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        List<String> res = new ArrayList<>();
        combination(chars, res, new StringBuilder(chars.length), 0);
        return res;
    }

    private static void combination(char[] chars, List<String> res, StringBuilder sb, int idx) {
        if (idx == chars.length) {
            if (sb.length() > 0) {
                res.add(sb.toString());
            }
        } else if (idx == chars.length - 1 || chars[idx] != chars[idx + 1]) {
            // No duplicate char
            combination(chars, res, sb.append(chars[idx]), idx + 1);
            sb.deleteCharAt(sb.length() - 1);
            combination(chars, res, sb, idx + 1);

        } else {
            // calculate the number of duplicates
            int firstDuplicateIndex = idx;
            while (idx != chars.length && chars[firstDuplicateIndex] == chars[idx]) {
                sb.append(chars[idx]);
                idx++;
            }
            int newStart = idx;
            while (idx >= firstDuplicateIndex) {
                combination(chars, res, sb, newStart);
                if (idx != firstDuplicateIndex) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                idx--;
            }
        }
    }
}
