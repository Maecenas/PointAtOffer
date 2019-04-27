package PointAtOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q47_StreamMedian {

    private static PriorityQueue<Double> left;
    private static PriorityQueue<Double> right;
    private static int N = 0;

    public Q47_StreamMedian() {
        left = new PriorityQueue<>(Comparator.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void add(double val) {
        if ((N & 0x1) == 0x0) {
            left.add(val);
            right.add(left.poll());
        } else {
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    public double getMedian() {
        if (N != 0 && ((N & 0x1) == 0x0)) {
            return left.peek() / 2.0 + right.peek() / 2.0;
        } else {
            return right.peek();
        }
    }
}
