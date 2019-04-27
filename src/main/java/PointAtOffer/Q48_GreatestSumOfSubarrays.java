package PointAtOffer;

public class Q48_GreatestSumOfSubarrays {

    public static int findGreastestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum = Math.max(sum, 0) + num;
            res = Math.max(res, sum);
        }
        return res;
    }
}
