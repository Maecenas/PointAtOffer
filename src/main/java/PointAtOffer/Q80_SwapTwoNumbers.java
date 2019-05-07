package PointAtOffer;

/**
 * Swap two integers without using new variable
 */
public class Q80_SwapTwoNumbers {

    public static int[] swap(int[] nums) {
        if (nums == null || nums.length != 2) return new int[0];

        // Using {@code +, -}
        // nums[0] += nums[1];
        // nums[1] = nums[0] - nums[1];
        // nums[0] -= nums[1];

        // Using bitwise operation
        nums[0] ^= nums[1];
        nums[1] ^= nums[0];
        nums[0] ^= nums[1];

        return nums;
    }
}
