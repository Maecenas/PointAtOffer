package PointAtOffer;

public class Q18_Power {

    public static double power(double base, int exponent) {
        if (exponent == 0) return 1;
        else if (exponent == 1) return base;

        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }

        double pow = power(base * base, exponent >> 1);
        if ((exponent & 0x1) == 0x1) {
            pow *= base;
        }

        return isNegative ? (1.0 / pow) : pow;
    }
}
