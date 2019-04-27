package PointAtOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Q46_KLeastNumbers {

    /**
     * Min-Heap PriorityQueue implementation without modifying original Array
     * Works with streaming or big data
     * O(nlogk), O(k)
     */
    public static List<Integer> getLeastNumbersPQ(int[] nums, int k) {
        if (nums == null || k > nums.length || k <= 0) return new ArrayList<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }
}
