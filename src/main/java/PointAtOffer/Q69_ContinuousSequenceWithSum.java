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
}
