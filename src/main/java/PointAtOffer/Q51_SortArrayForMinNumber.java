package PointAtOffer;

import java.util.Arrays;

public class Q51_SortArrayForMinNumber {

    public static String printMinNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";

        int n = nums.length;
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++)
            numbers[i] = String.valueOf(nums[i]);
        Arrays.sort(numbers, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder res = new StringBuilder();
        for (String str : numbers) {
            res.append(str);
        }
        return res.toString();
    }
}
