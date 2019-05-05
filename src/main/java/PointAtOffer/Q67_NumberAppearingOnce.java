package PointAtOffer;

public class Q67_NumberAppearingOnce {

    /**
     * Using two integer a, b as BitSet to encode 4 different status (0, 1, 2, 3)
     * and can be reduced to 3 states (0, 1, 2). ceil(log3) = 2
     * Drawing state moving table as follows:
     * <p>
     * current  meet    ouput
     * ab       c        ab
     * ----------------------
     * 00       1        01
     * 00       0        00
     * 01       1        10
     * 01       0        01
     * 10       1        00
     * 10       0        10
     * <p>
     * From the table can be concluded as in digital logic,
     * First, we pick out a group of result by (output_a = 1)
     * Then, for each move, if any of a, b and c is the same with output_a,
     * we wrote down ORIGINAL else NOT value and use AND to concatenate them.
     * Last, use OR to connect moves in a group
     * <p>
     * a = ( a & ~b & ~c) | (~a &  b & c)
     * b = (~a &  b & ~c) | (~a & ~b & c)
     * <p>
     * The number required is then encoded in b itself.
     */
    public static int findNumbersAppearingOnce(int[] nums) {
        if (nums == null) return 0;
        else if (nums.length == 1) return nums[0];
        else if (nums.length < 4) return 0;

        int a = 0, b = 0, tmpA;
        for (int c : nums) {
            tmpA = (a & ~b & ~c) | (~a & b & c);
            b = (~a & b & ~c) | (~a & ~b & c);
            a = tmpA;
        }
        // return a | b;
        return b;
    }
}
