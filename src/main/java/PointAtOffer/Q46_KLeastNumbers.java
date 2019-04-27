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

    /**
     * Partition implementation that would modify the original Array
     * O(n), O(1)
     */
    public static List<Integer> getLeastNumbersPartition(int[] nums, int k) {
        if (nums == null || k > nums.length || k <= 0) return new ArrayList<>();

        getKLeastNumbers(nums, k - 1);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(nums[i]);
        }
        return res;
    }

    /**
     * Iteratively select element to partition the Array,
     * if happens to make the first k element of nums less than v, return
     */
    private static void getKLeastNumbers(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1, j;
        while (lo < hi) {
            j = partition(nums, lo, hi);
            if (j == k) return;
            if (j > k) {
                hi = j - 1;
            } else {
                lo = j + 1;
            }
        }
    }

    /**
     * partition the subarray nums[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
     * and return the index j.
     */
    private static int partition(int[] nums, int lo, int hi) {
        int v = nums[lo], i = lo, j = hi + 1;

        // nums[lo] is unique largest element
        while (nums[++i] < v) {
            if (i == hi) {
                swap(nums, lo, hi);
                return hi;
            }
        }

        // nums[lo] is unique smallest element
        while (v < nums[--j]) {
            if (j == lo + 1) {
                return lo;
            }
        }

        // the main loop
        while (i < j) {
            swap(nums, i, j);
            while (i < hi - 1 && nums[++i] < v) ;
            while (j > lo && nums[--j] > v) ;
        }

        // put partitioning item v at nums[j]
        swap(nums, lo, j);

        // now, nums[lo .. j-1] <= nums[j] <= nums[j+1 .. hi]
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
