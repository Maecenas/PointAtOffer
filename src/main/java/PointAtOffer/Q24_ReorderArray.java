package PointAtOffer;

public class Q24_ReorderArray {

    public static void reorder(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int lo = 0, hi = nums.length - 1, temp;
        while (lo < hi) {
            while ((nums[lo] & 0x1) == 0x1) lo++;
            while ((nums[hi] & 0x1) == 0x0) hi--;
            if (lo < hi) {
                temp = nums[lo];
                nums[lo] = nums[hi];
                nums[hi] = temp;
            }
        }
    }
}
