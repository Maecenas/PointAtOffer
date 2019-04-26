package PointAtOffer;

public class Q45_MoreThanHalfNumber {

    public static int moreThanHalfNum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate ? 1 : -1);
        }
        return candidate;
    }
}
