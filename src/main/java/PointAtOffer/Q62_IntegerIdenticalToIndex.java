package PointAtOffer;

public class Q62_IntegerIdenticalToIndex {

    public static int getNumberSameAsIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int lo = 0, hi = nums.length - 1, mid;
        if (nums[lo] > 0 || nums[hi] < 0) return -1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == mid) {
                return mid;
            } else if (nums[mid] < mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(getNumberSameAsIndex(new int[]{-3, -1, 1, 3, 5})); //3
        System.out.println(getNumberSameAsIndex(new int[]{0, 1, 2, 3, 4}));   //0~4
        System.out.println(getNumberSameAsIndex(new int[]{4, 5, 6, 7, 8}));   //-1
    }
}
