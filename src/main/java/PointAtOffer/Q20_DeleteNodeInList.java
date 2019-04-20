package PointAtOffer;

import PointAtOffer.utils.ListNode;

public class Q20_DeleteNodeInList {

    /**
     * O(1)/ O(n), O(1)
     */
    public static ListNode<Integer> deleteNode(ListNode<Integer> head, ListNode<Integer> node) {
        if (head == null || node == null) return null;

        if (head == node) {
            // Only one item in LinkedList
            head = node = null;
        } else if (node.next != null) {
            // Copy
            node.val = node.next.val;
            node.next = node.next.next;
        } else {
            ListNode curr = head;
            while (curr.next != node) curr = curr.next;
            curr.next = null;
        }
        return head;
    }
}
