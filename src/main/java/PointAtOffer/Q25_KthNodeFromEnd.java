package PointAtOffer;

import PointAtOffer.utils.ListNode;

public class Q25_KthNodeFromEnd {

    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) return null;

        ListNode slow = head, fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
