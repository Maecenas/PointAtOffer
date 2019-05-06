package PointAtOffer;

public class Q77_MaximalProfit {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int minSoFar = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // prices[i] appear after minSoFar
            minSoFar = Math.min(minSoFar, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
        }
        return maxProfit;
    }
}
