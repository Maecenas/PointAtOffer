package PointAtOffer;

import java.util.ArrayList;
import java.util.List;

public class Q69_ContinuousSequenceWithSum {

    public static List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (sum < 3) return res;

        int lo = 1, hi = 2, curr = 3;
        while (hi < sum) {
            if (curr > sum) {
                curr -= lo;
                lo++;
            } else if (curr < sum) {
                hi++;
                curr += hi;
            } else {
                // curr == sum
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = lo; i <= hi; i++)
                    list.add(i);
                res.add(list);
                curr -= lo;
                lo++;
                hi++;
                curr += hi;
            }
        }
        return res;
    }

    /**
     * Expand sequence around center at each 0.5 increment
     */
    public static List<List<Integer>> findContinuousSequence2(int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (sum < 3) return res;

        int mid = sum;
        // multiply sum by 2 to avoid float calculation
        sum <<= 1;
        while (mid > 0) {
            if (sum % mid == 0) {
                int div = sum / mid;
                if ((div & 0x1) == 1) {
                    // div is odd
                    int n = (mid >> 1) - (div >> 1);
                    if (n > 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        while (n <= (mid >> 1) + (div >> 1)) {
                            list.add(n++);
                        }
                        res.add(list);
                    }
                } else {
                    // div is even
                    int n = (mid >> 1) - ((div - 1) >> 1);
                    if (n > 0 && ((mid & 0x1) == 0x1)) {
                        ArrayList<Integer> list = new ArrayList<>();
                        while (n <= (mid >> 1) + (div >> 1)) {
                            list.add(n++);
                        }
                        res.add(list);
                    }
                }
            }
            mid--;
        }
        // Collections.reverse(res);
        return res;
    }
}
