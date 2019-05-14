package PointAtOffer;

import PointAtOffer.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q31_SymmetricalBinaryTree {

    public static boolean isSymmetricalRecursively(TreeNode root) {
        if (root == null) return true;
        else if (root.left == null || root.right == null) return root.left == null && root.right == null;

        return isSymmetricalRecursively(root.left, root.right);
    }

    private static boolean isSymmetricalRecursively(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) return node1 == null && node2 == null;

        if (!node1.val.equals(node2.val)) {
            return false;
        } else {
            return isSymmetricalRecursively(node1.left, node2.right) && isSymmetricalRecursively(node1.right, node2.left);
        }
    }

    /**
     * See also {@link Q07_TraversalOfBinaryTree#levelorder}
     */
    public static boolean isSymmetricalIteratively(TreeNode root) {
        if (root == null) return true;
        else if (root.left == null || root.right == null) return root.left == null && root.right == null;

        // q1 is for level-order traversal, and q2 is for “reverse” level-order traversal (from right to left)
        Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        q1.offer(root.left);
        q2.offer(root.right);
        TreeNode tmp1, tmp2;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            tmp1 = q1.poll();
            tmp2 = q2.poll();
            if (!tmp1.val.equals(tmp2.val)) return false;

            if (tmp1.left != null) q1.offer(tmp1.left);
            if (tmp1.right != null) q1.offer(tmp1.right);
            if (tmp2.right != null) q2.offer(tmp2.right);
            if (tmp2.left != null) q2.offer(tmp2.left);
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}
