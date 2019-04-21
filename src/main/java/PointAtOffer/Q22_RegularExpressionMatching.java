package PointAtOffer;

public class Q22_RegularExpressionMatching {

    /**
     * Recursive implementation of RegExp matching
     */
    public static boolean isMatchRecursive(String text, String pattern) {
        if (text == null || pattern == null) return false;

        if (pattern.isEmpty()) return text.isEmpty();
        boolean isMatchFirst = (!text.isEmpty()
                && (pattern.charAt(0) == text.charAt(0)
                || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatchRecursive(text, pattern.substring(2))
                    || (isMatchFirst && isMatchRecursive(text.substring(1), pattern)));
        } else {
            return isMatchFirst && isMatchRecursive(text.substring(1), pattern.substring(1));
        }
    }

    /**
     * Describe the question as:
     * <i>dp(i, j) = (text[i:] and pattern[j:] matches)</i>
     * <p>
     * Use {@code dp[i][j]} to handle recursive calls in {@code isMatchRecursive}
     */
    public static boolean isMatchDPTopDown(String text, String pattern) {
        if (text == null || pattern == null) return false;

        final Boolean[][] dp = new Boolean[text.length() + 1][pattern.length() + 1];
        return isMatchDPTopDown(text, pattern, 0, 0, dp);
    }

    private static boolean isMatchDPTopDown(final String text, final String pattern, final int i, final int j, final Boolean[][] dp) {
        if (dp[i][j] != null) return dp[i][j];

        boolean ans;
        if (j == pattern.length()) {
            ans = (i == text.length());
        } else {
            boolean isMatchFirst = (i < text.length()
                    && (pattern.charAt(j) == text.charAt(i)
                    || pattern.charAt(j) == '.'));
            if (pattern.length() - j >= 2 && pattern.charAt(j + 1) == '*') {
                ans = isMatchDPTopDown(text, pattern, i, j + 2, dp)
                        || (isMatchFirst
                        && isMatchDPTopDown(text, pattern, i + 1, j, dp));
            } else {
                ans = (isMatchFirst
                        && isMatchDPTopDown(text, pattern, i + 1, j + 1, dp));
            }
        }
        dp[i][j] = ans;
        return ans;
    }

    public static boolean isMatchDPBottomUp(String text, String pattern) {
        if (text == null || pattern == null) return false;

        final boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean isMatchFirst = (i < text.length()
                        && (pattern.charAt(j) == text.charAt(i)
                        || pattern.charAt(j) == '.'));
                if (pattern.length() - j >= 2 && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (isMatchFirst && dp[i + 1][j]);
                } else {
                    dp[i][j] = isMatchFirst && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
