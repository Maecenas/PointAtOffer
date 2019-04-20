package PointAtOffer;

public class Q16_CuttingRope {

    public static int maxProductAfterCuttingDP(int length) {
        if (length <= 1) return 0;

        int[] products = new int[length + 1];
        products[1] = 1;

        for (int i = 2; i <= length; i++)
            // f(i) = max(f(j) * f(i - j))
            for (int j = 1; j < i; j++)
                products[i] = Math.max(
                        products[i],
                        Math.max(j, products[j]) * Math.max(i - j, products[i - j])
                );
        return products[length];
    }

    public static int maxProductAfterCuttingGreedy(int length) {
        if (length <= 1) return 0;

        int timesOf3 = length / 3;
        if (length % 3 == 1) timesOf3--;
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}
