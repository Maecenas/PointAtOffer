package PointAtOffer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Q24_ReorderArray {

    public static void reorder(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int lo = 0, hi = nums.length - 1, temp;
        while (lo < hi) {
            while ((nums[lo] & 0x1) == 0x1) lo++;
            while ((nums[hi] & 0x1) == 0x0) hi--;
            if (lo < hi) {
                temp = nums[lo];
                nums[lo] = nums[hi];
                nums[hi] = temp;
            }
        }
    }

    /**
     * General solution with given method as argument
     */
    public static void reorder(int[] nums, Method func) {
        if (nums == null || nums.length <= 1) return;

        int lo = 0, hi = nums.length - 1, temp;
        try {
            while (lo < hi) {
                while (!(boolean) func.invoke(null, nums[lo])) lo++;
                while ((boolean) func.invoke(null, nums[hi])) hi--;
                if (lo < hi) {
                    temp = nums[lo];
                    nums[lo] = nums[hi];
                    nums[hi] = temp;
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static boolean isEven(int n) {
        return (n & 0x1) == 0x0;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 7, 7};

        try {
            Method method = Q24_ReorderArray.class.getMethod("isEven", Integer.TYPE);
            reorder(data, method);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(data));
    }
}
