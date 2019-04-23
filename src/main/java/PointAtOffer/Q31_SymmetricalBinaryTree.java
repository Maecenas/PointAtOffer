package PointAtOffer;

import PointAtOffer.utils.TreeNode;

public class Q31_SymmetricalBinaryTree {

    public static boolean isSymmetrical(TreeNode root) {
        if (root == null) return true;
        else if (root.left == null || root.right == null) return root.left == null && root.right == null;

        return isSymmetrical(root.left, root.right);
    }

    private static boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == null && root2 == null;

        if (!root1.val.equals(root2.val)) {
            return false;
        } else {
            return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
        }
    }
}
