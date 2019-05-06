package PointAtOffer;

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
}
