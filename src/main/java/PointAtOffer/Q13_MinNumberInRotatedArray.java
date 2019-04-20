package PointAtOffer;

public class Q13_MinNumberInRotatedArray {

    public static int min(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int lo = 0, hi = nums.length - 1, mid;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] <= nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo];
    }

    public static int minWithDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int lo = 0, hi = nums.length - 1, mid;


        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
                // Switch to O(n) sequential search
                for (int i = lo; i < hi; i++) {
                    if (nums[i] > nums[i + 1]) {
                        return nums[i + 1];
                    }
                }
                return nums[lo];
            } else if (nums[mid] <= nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo];
    }
}
