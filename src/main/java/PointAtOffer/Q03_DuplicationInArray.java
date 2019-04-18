package PointAtOffer;

/**
 * Given array[] containing items of value [0, n-1], find any duplicate item
 */
public class Q03_DuplicationInArray {

    /**
     * Not modify original data, O(nlogn), O(n)
     */
    public static int getDuplication(int[] data) {
        if (data == null || data.length <= 1) return -1;

        int[] map = new int[data.length];
        for (int item : data) {
            if (map[item] >= 1) {
                return item;
            } else {
                map[item] = 1;
            }
        }
        return -1;
    }
}
