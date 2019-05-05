package PointAtOffer;

public class Q68_TwoSumInSortedArray {

    public static int[] findNumbersWithSum(int[] nums, int sum) {
        if (nums == null || nums.length < 2) return new int[0];

        int lo = 0, hi = nums.length - 1, curr;
        while (lo < hi) {
            curr = nums[lo] + nums[hi];
            if (curr == sum) {
                return new int[]{lo, hi};
            } else if (curr > sum) {
                hi--;
            } else {
                // curr < sum
                lo++;
            }
        }
        return new int[0];
    }
}
