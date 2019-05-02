package PointAtOffer;

public class Q53_MaxValueOfGifts {

    /**
     * Bottom-Up Dynamic Programming
     */
    public static int getMaxValue(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) return 0;

        int R = values.length, C = values[0].length;
        int curr, prev;  // row index of 0, 1
        // Row by row calculation to reduce memory from O(R * C) to O(C)
        int[][] dp = new int[2][C];
        // row -> col iteration
        for (int row = 0; row < R; row++) {
            curr = row & 0x1;
            // better performance vs. poor readability
            // prev = curr == 1 ? 0 : 1;
            prev = 1 - curr;
            // col == 0
            dp[curr][0] = dp[prev][0] + values[row][0];
            for (int col = 1; col < C; col++) {
                dp[curr][col] = Math.max(dp[prev][col], dp[curr][col - 1]) + values[row][col];
            }
        }
        return dp[(R - 1) & 0x1][C - 1];
    }
}
