package PointAtOffer;

/**
 * Construct B[] where B[i] = sum(A) / A[i], without using division
 */
public class Q81_ConstructArray {

    public static int[] multiply(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];

        final int n = nums.length;
        final int[] res = new int[n];

        // Calculate B[i] by two parts
        // B[i] = {A[0] * A[1] * ... A[i - 1]} * {A[i + 1] * A[i + 2] * ... A[n]}
        for (int i = 0, product = 1; i < n; product *= nums[i], i++) {
            res[i] = product;
        }
        for (int i = n - 1, product = 1; i >= 0; product *= nums[i], i--) {
            res[i] *= product;
        }
        return res;
    }
}
