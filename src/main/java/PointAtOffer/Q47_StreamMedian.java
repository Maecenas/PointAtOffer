package PointAtOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q47_StreamMedian {

    private static PriorityQueue<Double> left = new PriorityQueue<>();
    private static PriorityQueue<Double> right = new PriorityQueue<>(Comparator.reverseOrder());
    private static int N = 0;

    public void add(double val) {
        if ((N & 0x1) == 0x0) {
            // even, add to left
            right.add(val);
            left.add(right.poll());
        } else {
            // odd, add to right
            left.add(val);
            right.add(left.poll());
        }
        N++;
    }

    public double getMedian() {
        if ((N & 0x1) == 0x0) {
            // even
            return right.peek() / 2.0 + left.peek() / 2.0;
        } else {
            // odd
            return left.peek();
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
