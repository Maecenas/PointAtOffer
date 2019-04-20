package PointAtOffer;

public class Q17_NumberOf1InBinary {

    public static int numberOfOne1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    public static int numberOfOne2(int n) {
        return Integer.bitCount(n);
    }

}
