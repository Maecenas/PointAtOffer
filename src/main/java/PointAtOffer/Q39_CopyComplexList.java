package PointAtOffer;

public class Q39_CopyComplexList {

    static class ComplexListNode {

        int val;
        ComplexListNode next, random;

        ComplexListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            StringBuilder ret = new StringBuilder();
            ComplexListNode curr = this;
            while (curr != null) {
                ret.append(curr.val);
                if (curr.random != null) {
                    ret.append("(").append(curr.random.val).append(")");
                } else {
                    ret.append("(_)");
                }
                ret.append('\t');
                curr = curr.next;
            }
            return ret.toString();
        }
    }

    public static ComplexListNode clone(ComplexListNode head) {
        if (head == null) return null;

        // clone nodes by inserting new node after each element
        ComplexListNode curr = head, clone;
        while (curr != null) {
            clone = new ComplexListNode(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }
        // connect random nodes
        curr = head;
        while (curr != null) {
            clone = curr.next;
            if (curr.random != null) {
                clone.random = curr.random.next;
            }
            curr = clone.next;
        }
        // re-connect and separate cloned nodes
        curr = head;
        final ComplexListNode newHead = head.next;
        while (curr.next != null) {
            clone = curr.next;
            curr.next = clone.next;
            curr = clone;
        }
        return newHead;
    }
}
