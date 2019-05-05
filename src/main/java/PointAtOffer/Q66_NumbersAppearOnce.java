package PointAtOffer;

public class Q66_NumbersAppearOnce {

    public static int[] findNumsAppearOnce(int[] nums) {
        int[] res = new int[]{0, 0};
        if (nums == null || nums.length < 3) return res;

        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get last the bit of 1
        // diff &= -diff
        // -x = ~x - 1
        diff ^= (diff - 1);

        for (int num : nums) {
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
