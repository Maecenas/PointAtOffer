package PointAtOffer;

import PointAtOffer.utils.ListNode;

public class Q59_FirstCommonNodesInLists {

    /**
     * Swap l1 and l2 to the other starting when meet ends,
     * so that they would pass the same distance when first meet
     */
    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }
}
