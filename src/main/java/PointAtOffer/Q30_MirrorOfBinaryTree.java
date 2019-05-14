package PointAtOffer;

import PointAtOffer.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q30_MirrorOfBinaryTree {

    public static void mirrorRecursively(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;

        swap(root);
        mirrorRecursively(root.left);
        mirrorRecursively(root.right);
    }

    /**
     * See also {@link Q07_TraversalOfBinaryTree#levelorder}
     */
    public static void mirrorIteratively(TreeNode<Integer> root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            swap(curr);
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
    }

    private static void swap(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
