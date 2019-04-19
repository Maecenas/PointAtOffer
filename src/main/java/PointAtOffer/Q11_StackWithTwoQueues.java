package PointAtOffer;

import java.util.LinkedList;
import java.util.Queue;

public class Q11_StackWithTwoQueues {

    /**
     * Only one of queue1 and queue2 can contain items at the same time
     * When pop() is called, all item are offered to the other stack, except for the stack top (queue bottom)
     */
    static class MyStack<T> {

        Queue<T> queue1 = new LinkedList<>(), queue2 = new LinkedList<>();

        void push(T item) {
            if (!queue2.isEmpty()) queue2.offer(item);
            else queue1.offer(item);
        }

        T pop() {
            if (!queue2.isEmpty()) {
                while (queue2.size() > 1) {
                    queue1.offer(queue2.poll());
                }
                return queue2.poll();
            } else if (!queue1.isEmpty()) {
                while (queue1.size() > 1) {
                    queue2.offer(queue1.poll());
                }
                return queue1.poll();
            } else {
                return null;
            }
        }
    }
}
