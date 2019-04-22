package PointAtOffer;

import PointAtOffer.utils.ListNode;

public class Q27_ReverseList {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newList = new ListNode(null), next;
        while (head != null) {
            next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }
}
