package PointAtOffer;

import java.util.Arrays;

public class Q75_ContinuousCards {

    private static final int K = 5;

    public static boolean isContinuous(int[] nums) {
        if (nums == null || nums.length != K) return false;

        // Valid input contains only [0, 13]
        int[] cards = new int[14];
        for (int num : nums) {
            if (num > 13 || num < 0) return false;
            else if (num > 0 && cards[num] > 1) return false;

            cards[num]++;
        }
        int king = cards[0];

        int start = 1;
        while (cards[start] == 0) {
            start++;
        }

        for (int i = start; i < start + K - king; i++) {
            if (cards[i] == 0) {
                if (king == 0) {
                    return false;
                } else {
                    king--;
                }
            }
        }
        return true;
    }

    public static boolean isContinuous2(int[] nums) {
        if (nums == null || nums.length != 5) return false;

        Arrays.sort(nums);

        int king = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                king++;
            } else {
                if (nums[i + 1] == nums[i]) {
                    return false;
                }
                king -= (nums[i + 1] - nums[i] - 1);
            }
        }
        // king > 0 when is used for prefix padding
        return king >= 0;
    }
}
