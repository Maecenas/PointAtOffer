package PointAtOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Q72_MaxInSlidingWindow {

    public static List<Integer> maxInWindows(int[] nums, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size > nums.length || size < 1) return res;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < size; i++) {
            pq.add(nums[i]);
        }

        res.add(pq.peek());
        for (int i = 0, j = i + size; j < nums.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            pq.remove(nums[i]);
            pq.add(nums[j]);
            res.add(pq.peek());
        }

        return res;
    }
}
