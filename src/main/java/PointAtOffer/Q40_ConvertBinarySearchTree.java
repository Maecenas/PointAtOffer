package PointAtOffer;

import PointAtOffer.utils.TreeNode;

public class Q40_ConvertBinarySearchTree {

    private static TreeNode prev, head;

    public static TreeNode convert(TreeNode root) {
        if (root == null) return null;

        inOrderConvert(root);
        return head;
    }

    private static void inOrderConvert(TreeNode node) {
        if (node == null) return;

        inOrderConvert(node.left);
        node.left = prev;
        if (prev != null) {
            prev.right = node;
        }
        prev = node;
        if (head == null) {
            head = node;
        }
        inOrderConvert(node.right);
    }
}
