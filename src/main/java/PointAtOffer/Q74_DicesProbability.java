package PointAtOffer;

public class Q74_DicesProbability {

    private static final int FACES = 6;

    /**
     * Dynamic Programming
     * where dp[i][j] is the amount of rolling nums j using i dices
     * O(n), O(n^2)
     */
    public static double[] dicesSum(int n) {
        if (n <= 0) return new double[0];

        final int nums = n * FACES;
        int[][] dp = new int[n + 1][nums + 1];

        // Arrays.fill(dp[1], 1, FACES, 1);
        for (int i = 1; i <= FACES; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            // Using i indices, get [i, i * FACES] results
            for (int j = i; j <= nums; j++) {
                // f(n) = f(n - 1) + f(n - 2) + ... + f(n - 6)
                for (int k = 1; k <= FACES && k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        final double total = Math.pow(FACES, n);
        final double[] res = new double[nums];
        // Using n indices, get [n, n * FACES] results
        for (int i = n; i <= nums; i++) {
            res[i - n] = dp[n][i] / total;
        }
        return res;
    }
}
