package PointAtOffer;

import java.util.Stack;

public class Q10_QueueWithTwoStacks {

    /**
     * stack1 is for offer(), and stack2 in reverse sequence of stack1, is for poll()
     */
    static class MyQueue<T> {

        private Stack<T> stack1 = new Stack<>(), stack2 = new Stack<>();

        void offer(T data) {
            stack1.push(data);
        }

        T poll() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            } else {
                return null;
            }
        }
    }
}
