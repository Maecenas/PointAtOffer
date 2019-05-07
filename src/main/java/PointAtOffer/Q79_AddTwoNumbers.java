package PointAtOffer;

/**
 * Add two integers without using {@code +, -, *, /}
 */
public class Q79_AddTwoNumbers {

    public static int add(int a, int b) {
        if (b == 0) return a;
        else if (a == 0) return b;

        int sum;  // add without carry
        int carry;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        } while (b != 0);

        return a;
    }
}
