package PointAtOffer;

public class Q60_NumberOfK {

    public static int getNumberOfK(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;

        final int first = binarySearch(nums, k);
        final int last = binarySearch(nums, k + 1);
        if (first == nums.length || nums[first] != k) {
            return -1;
        } else {
            return last - first;
        }
    }

    /**
     * Return the first occurrence index of k in array, index to insert if not found
     */
    private static int binarySearch(int[] nums, int k) {
        int lo = 0, hi = nums.length, mid;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
