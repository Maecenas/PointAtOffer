package PointAtOffer;

/**
 * Given array[] containing items of value [0, n-1], find any duplicate item
 */
public class Q03_DuplicationInArray {

    /**
     * Not modify original data, O(nlogn), O(n)
     */
    public static int getDuplication(int[] data) {
        if (data == null || data.length <= 1) return -1;

        int[] map = new int[data.length];
        for (int item : data) {
            if (map[item] >= 1) {
                return item;
            } else {
                map[item] = 1;
            }
        }
        return -1;
    }

    /**
     * Copy nums[i] to nums[nums[i]], if already present then is duplicate
     */
    public static int getDuplication2(int[] nums) {
        if (nums == null || nums.length <= 0) return -1;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
