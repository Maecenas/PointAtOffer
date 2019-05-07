package PointAtOffer;

/**
 * Calculate the accumulate of 1, 2, ..., n without using statements like:
 * {@code *, /, for, while, if, else, switch, case}
 */
public class Q78_Accumulate {

    public static int getSum(int n) {
        if (n < 0) return -1;

        int sum = n;
        // Using recursive calls and logical AND to terminate
        boolean tmp = (n > 0) && ((sum += getSum(n - 1)) > 0);
        return sum;
    }
}
