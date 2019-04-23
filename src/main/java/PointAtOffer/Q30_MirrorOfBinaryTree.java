package PointAtOffer;

import PointAtOffer.utils.TreeNode;

public class Q30_MirrorOfBinaryTree {

    public static void mirror(TreeNode root) {
        if (root == null || root.left == null || root.right == null) return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirror(root.left);
        mirror(root.right);
    }
}
