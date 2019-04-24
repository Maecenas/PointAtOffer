package PointAtOffer;

import java.util.EmptyStackException;
import java.util.Stack;

public class Q33_StackWithMin<T extends Comparable> {

    private Stack<T> stack = new Stack<>(), min = new Stack<>();

    public void push(T item) {
        stack.push(item);
        if (min.isEmpty() || item.compareTo(min.peek()) < 0) {
            min.push(item);
        } else {
            min.push(min.peek());
        }
    }

    public T pop() {
        if (stack.isEmpty()) throw new EmptyStackException();
        min.pop();
        return stack.pop();
    }

    public T min() {
        if (stack.isEmpty()) throw new EmptyStackException();
        return min.peek();
    }

}
