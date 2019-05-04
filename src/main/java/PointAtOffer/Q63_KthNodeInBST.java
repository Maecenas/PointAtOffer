package PointAtOffer;

import PointAtOffer.utils.TreeNode;

public class Q63_KthNodeInBST {

    private static TreeNode ret;
    private static int cnt;

    public static TreeNode kthNode(TreeNode root, int k) {
        cnt = 0;
        ret = null;
        inOrder(root, k);
        return ret;
    }

    private static void inOrder(TreeNode root, int k) {
        if (root == null || cnt >= k) return;

        inOrder(root.left, k);
        cnt++;
        if (cnt == k) {
            ret = root;
            return;
        }
        inOrder(root.right, k);
    }
}