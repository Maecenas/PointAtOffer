package PointAtOffer;

import PointAtOffer.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q64_TreeDepth {

    public static int treeDepthRecursively(TreeNode root) {
        if (root == null) return 0;

        final int left = treeDepthRecursively(root.left);
        final int right = treeDepthRecursively(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * BFS/ Level-order traversal
     * See also {@code Q07_TraversalOfBinaryTree.levelorder()},
     *          {@code Q35_PrintTreeInLines}
     */
    public static int treeDepthIteratively(TreeNode root) {
        if (root == null) return 0;

        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode curr;
        while (!q.isEmpty()) {
            depth++;
            // Calling size() once to reduce the impact of modify on iteration
            // However, keep calling seems to result in the same but more complex
            // for (int size = 0; size < q.size(); size++) {
            for (int size = q.size(); size > 0; size--) {
                curr = q.poll();
                assert curr != null;
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
        }
        return depth;
    }
}
