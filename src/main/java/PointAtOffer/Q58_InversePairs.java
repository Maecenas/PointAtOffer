package PointAtOffer;

public class Q58_InversePairs {

    private static long count = 0;
    private static int[] aux;

    public static int inversePairs(int[] nums) {
        aux = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return (int) count;
    }

    private static void mergeSort(int[] nums, int lo, int hi) {
        if (hi - lo < 1) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private static void merge(int[] src, int lo, int mid, int hi) {
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid || j <= hi) {
            if (i > mid) {
                aux[k] = src[j++];
            } else if (j > hi) {
                aux[k] = src[i++];
            } else if (src[i] < src[j]) {
                aux[k] = src[i++];
            } else {
                aux[k] = src[j++];
                // nums[i] >= nums[j] => nums[i...mid] > nums[j]
                count += mid - i + 1;
            }
            k++;
        }
        // for (k = lo; k <= hi; k++) {
        //     src[k] = aux[k];
        // }
        System.arraycopy(aux, lo, src, lo, hi - lo + 1);
    }
}
