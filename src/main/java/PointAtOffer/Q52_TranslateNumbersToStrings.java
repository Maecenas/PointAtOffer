package PointAtOffer;

public class Q52_TranslateNumbersToStrings {

    public static int getTranslationCount(String s) {
        if (s == null || s.length() == 0) return 0;

        int n = s.length();
        int oneDigit, twoDigit;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            // Since JDK 9
            // oneDigit = Integer.parseInt(s, i - 1, i, 10);
            oneDigit = Integer.valueOf(s.substring(i - 1, i));
            if (oneDigit != 0) {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            // Since JDK 9
            // twoDigit = Integer.parseInt(s, i - 2, i, 10);
            twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if (twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
