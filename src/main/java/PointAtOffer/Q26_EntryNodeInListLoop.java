package PointAtOffer;

import PointAtOffer.utils.ListNode;

public class Q26_EntryNodeInListLoop {

    public static ListNode meetingNode(ListNode head) {
        if (head == null) return null;

        ListNode slow = head, fast = head;

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        // Math proof: head -> entrance == fast -> entrance
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
