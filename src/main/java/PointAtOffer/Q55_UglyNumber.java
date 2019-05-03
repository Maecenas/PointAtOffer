package PointAtOffer;

public class Q55_UglyNumber {

    public static int getUglyNumber(int num) {
        if (num <= 0) return 0;
        else if (num <= 6) return num;

        int i2 = 0, i3 = 0, i5 = 0;
        int next2, next3, next5;
        int[] dp = new int[num];
        dp[0] = 1;
        for (int i = 1; i < num; i++) {
            next2 = dp[i2] * 2;
            next3 = dp[i3] * 3;
            next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2) i2++;
            if (dp[i] == next3) i3++;
            if (dp[i] == next5) i5++;
        }
        return dp[num - 1];
    }
}
