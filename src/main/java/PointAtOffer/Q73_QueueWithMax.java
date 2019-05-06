package PointAtOffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Maintaining two Deque and an index to provide a Queue with {@code max()}
 * <p>
 * For push: when meet a smaller item, just insert also into max queue,
 * so that {@code pop()} the remaining results would work correctly;
 * <p>
 * when meet a greater item, delete all previous items in max queue,
 * so that {@code pop()} until the greatest element would work.
 * <p>
 * For pop:  also pop() max queue if heads of them peek() are the same item
 */
public class Q73_QueueWithMax<T extends Comparable> {

    private Deque<IndexedItem<T>> queue;
    private Deque<IndexedItem<T>> max;
    private int currentIndex;

    static class IndexedItem<T extends Comparable> {

        T val;
        int index;

        IndexedItem(T value, int index) {
            this.val = value;
            this.index = index;
        }
    }

    public Q73_QueueWithMax() {
        this.queue = new ArrayDeque<>();
        this.max = new ArrayDeque<>();
        this.currentIndex = 0;
    }

    public T max() {
        if (max.isEmpty()) return null;
        return max.getFirst().val;
    }

    public void push(T item) {
        if (item == null) return;

        while (!max.isEmpty() && item.compareTo(max.getLast().val) >= 0) {
            max.removeLast();
        }
        IndexedItem<T> insert = new IndexedItem<>(item, currentIndex);
        max.addLast(insert);
        queue.addLast(insert);
        currentIndex++;
    }

    public T pop() {
        if (queue.isEmpty()) return null;

        IndexedItem<T> del = queue.removeFirst();
        if (del.index == max.getFirst().index) {
            max.removeFirst();
        }
        return del.val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (IndexedItem item : queue) {
            sb.append(item.val);
            sb.append(", ");
        }
        return sb.append("]").toString();
    }
}
