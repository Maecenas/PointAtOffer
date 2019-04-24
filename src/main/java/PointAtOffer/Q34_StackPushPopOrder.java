package PointAtOffer;

import java.util.Stack;

public class Q34_StackPushPopOrder {

    public static boolean isPopOrder(int[] pushSeq, int[] popSeq) {
        if (pushSeq == null || popSeq == null || pushSeq.length != popSeq.length) return false;

        Stack<Integer> stack = new Stack<>();
        int n = pushSeq.length;
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSeq[pushIndex]);
            while (popIndex < n && !stack.isEmpty() && stack.peek() == popSeq[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
