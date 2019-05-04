package PointAtOffer;

public class Q61_GetMissingNumber {

    public static int getMissingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int lo = 0, hi = nums.length - 1, mid;
        // Note exit condition
        // return (lo + 1) would fail for missing 0
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
