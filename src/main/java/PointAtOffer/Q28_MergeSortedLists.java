package PointAtOffer;

import PointAtOffer.utils.ListNode;

public class Q28_MergeSortedLists {

    public static ListNode<Integer> mergeRecursive(ListNode<Integer> head1, ListNode<Integer> head2) {
        if (head1 == null) return head2;
        else if (head2 == null) return head1;

        if (head1.val <= head2.val) {
            head1.next = mergeRecursive(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeRecursive(head1, head2.next);
            return head2;
        }
    }

    public static ListNode<Integer> mergeIterative(ListNode<Integer> head1, ListNode<Integer> head2) {
        if (head1 == null) return head2;
        else if (head2 == null) return head1;

        ListNode<Integer> head = new ListNode<>(-1), curr = head;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        if (head1 != null) curr.next = head1;
        else curr.next = head2;
        return head.next;
    }
}
