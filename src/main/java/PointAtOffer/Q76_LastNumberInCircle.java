package PointAtOffer;

import PointAtOffer.utils.ListNode;

/**
 * Josephus problem
 */
public class Q76_LastNumberInCircle {

    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) return -1;

        // Set Circular Linked List
        ListNode<Integer> head = new ListNode<>(0);
        ListNode<Integer> curr = head;
        for (int i = 1; i < n; i++) {
            curr.next = new ListNode<>(i);
            curr = curr.next;
        }
        curr.next = head;
        curr = head;

        while (true) {
            // Finish when only one item in circle
            if (curr.next == curr) {
                return curr.val;
            }
            // Move backward
            for (int i = 1; i < m; i++)
                curr = curr.next;
            // Delete current node
            // curr is now the next node
            curr.val = curr.next.val;
            curr.next = curr.next.next;
        }
    }

    public static int lastRemainingRecursively(int n, int m) {
        if (n < 1 || m < 1) return -1;

        // recursive call ends
        if (n == 1) return 0;
        return (lastRemainingRecursively(n - 1, m) + m) % n;
    }

    public static int lastRemainingIteratively(int n, int m) {
        if (n < 1 || m < 1) return -1;

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
