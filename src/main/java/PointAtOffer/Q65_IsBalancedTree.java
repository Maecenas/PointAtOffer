package PointAtOffer;

import PointAtOffer.utils.TreeNode;

public class Q65_IsBalancedTree {

    private static boolean isBalanced = true;

    /**
     * See also {@code Q64_TreeDepth()}
     */
    public static boolean isBalanced(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }

    private static int getDepth(TreeNode root) {
        // early return
        if (root == null || !isBalanced) return 0;

        final int left = getDepth(root.left);
        // early return
        if (!isBalanced) return 0;

        final int right = getDepth(root.right);
        // early return
        if (!isBalanced) return 0;

        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(left, right);
    }
}
