package PointAtOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q47_StreamMedian {

    private static PriorityQueue<Double> left = new PriorityQueue<>();
    private static PriorityQueue<Double> right = new PriorityQueue<>(Comparator.reverseOrder());
    private static boolean isInputEven = true;

    public void add(double val) {
        if (isInputEven) {
            // even, add to left
            right.add(val);
            left.add(right.poll());
            // release memory
            if (left.size() > 2) {
                left.poll();
                right.poll();
            }
        } else {
            // odd, add to right
            left.add(val);
            right.add(left.poll());
            // release memory
            if (left.size() > 1) {
                left.poll();
                right.poll();
            }
        }
        isInputEven = !isInputEven;
    }

    public double getMedian() {
        if (isInputEven) {
            // even
            return right.peek() / 2.0 + left.peek() / 2.0;
        } else {
            // odd
            return left.peek();
        }
    }
}
