package PointAtOffer;

import PointAtOffer.utils.TreeNode;

/**
 * Given two TreeNode p and q, find the lowest common ancestor
 */
public class Q83_LowestCommonAncestorInTree {

    /**
     * In Binary Search Tree, find left or right until find a node of val in the middle of inputs
     */
    public static TreeNode<? extends Comparable> lowestCommonAncestorInBST(
            TreeNode<? extends Comparable> root,
            final TreeNode<? extends Comparable> p,
            final TreeNode<? extends Comparable> q) {
        if (root == null) return null;

        if (root.val.compareTo(p.val) > 0 && root.val.compareTo(q.val) > 0) {
            return lowestCommonAncestorInBST(root.left, p, q);
        } else if (root.val.compareTo(p.val) < 0 && root.val.compareTo(q.val) < 0) {
            return lowestCommonAncestorInBST(root.right, p, q);
        } else {
            return root;
        }
    }
}
