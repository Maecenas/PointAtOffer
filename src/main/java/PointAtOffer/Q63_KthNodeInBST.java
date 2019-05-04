package PointAtOffer;

import PointAtOffer.utils.TreeNode;

import java.util.Stack;

public class Q63_KthNodeInBST {

    private static TreeNode ret;
    private static int cnt;

    public static TreeNode kthNode(TreeNode root, int k) {
        if (root == null || k <= 0) return null;

        cnt = 0;
        // Recursive method calls
        // ret = null;
        // inOrderRecursively(root, k);
        // return ret;
        return inOrderIteratively(root, k);
    }

    private static void inOrderRecursively(TreeNode root, int k) {
        if (root == null || cnt >= k) return;

        inOrderRecursively(root.left, k);
        cnt++;
        if (cnt == k) {
            ret = root;
            return;
        }
        inOrderRecursively(root.right, k);
    }

    private static TreeNode inOrderIteratively(TreeNode root, int k) {
        if (root == null || cnt >= k) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                cnt++;
                if (cnt == k) {
                    return curr;
                }
                curr = curr.right;
            }
        }
        return null;
    }
}