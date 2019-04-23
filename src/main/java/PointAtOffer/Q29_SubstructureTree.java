package PointAtOffer;

import PointAtOffer.utils.TreeNode;

public class Q29_SubstructureTree {

    public static boolean hasSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;

        return isSubTreeOf(root1, root2) || hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
    }

    private static boolean isSubTreeOf(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        } else if (root1 == null) {
            return false;
        } else if (!root1.val.equals(root2.val)) {
            return false;
        } else {
            return isSubTreeOf(root1.left, root2.left) && isSubTreeOf(root1.right, root2.right);
        }
    }
}
