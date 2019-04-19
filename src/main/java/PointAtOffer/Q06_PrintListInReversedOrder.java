package PointAtOffer;

import PointAtOffer.utils.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q06_PrintListInReversedOrder {

    /**
     * Recursive
     */
    public List<Integer> printListFromTailToHead1(ListNode<Integer> listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead1(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    /**
     * Non-recursive using stack
     */
    public List<Integer> printListFromTailToHead2(ListNode<Integer> listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
    }

    /**
     * Reverse LinkedList using three pointers, O(n), O(1)
     */
    public List<Integer> printListFromTailToHead3(ListNode<Integer> listNode) {
        ListNode<Integer> head = new ListNode<>(-1), next;

        while (listNode != null) {
            next = listNode.next;
            // Insert listNode into head -> head.next
            listNode.next = head.next;
            head.next = listNode;
            listNode = next;
        }

        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }
}
