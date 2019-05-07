package PointAtOffer;

import PointAtOffer.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

    static class TreeNodeWithParent<T extends Comparable> {

        T val;
        TreeNodeWithParent<T> parent;
        TreeNodeWithParent<T> left;
        TreeNodeWithParent<T> right;

        public TreeNodeWithParent(T val, TreeNodeWithParent<T> parent) {
            this.val = val;
            this.parent = parent;
        }
    }

    /**
     * See also {@code Q59_FirstCommonNodesInLists}
     */
    public static TreeNodeWithParent<? extends Comparable> lowestCommonAncestorInBSTWithParent(
            TreeNodeWithParent<? extends Comparable> p,
            TreeNodeWithParent<? extends Comparable> q) {
        if (q == null || p == null) return null;

        TreeNodeWithParent l1 = p, l2 = q;
        while (l1.val.compareTo(l2.val) != 0) {
            l1 = (l1.parent == null) ? q : l1.parent;
            l2 = (l2.parent == null) ? p : l2.parent;
        }
        return l1;
    }

    /**
     * Searching lowest Common Ancestor in a common binary tree
     */
    public static TreeNode<? extends Comparable> lowestCommonAncestorRecursively(
            TreeNode<? extends Comparable> root,
            final TreeNode<? extends Comparable> p,
            final TreeNode<? extends Comparable> q) {
        if (root == null || root == p || root == q) return root;

        TreeNode<?> left = lowestCommonAncestorRecursively(root.left, p, q);
        TreeNode<?> right = lowestCommonAncestorRecursively(root.right, p, q);
        return right == null ? left : left == null ? right : root;
    }

    /**
     * See also <a>https://github.com/Maecenas/Algorithms-algs4-cos226-Princeton-Coursera#wordnet</a>
     */
    public static TreeNode lowestCommonAncestorIteratively(
            TreeNode<? extends Comparable> root,
            final TreeNode<? extends Comparable> p,
            final TreeNode<? extends Comparable> q) {
        if (root == null || root == p || root == q) return root;

        List<TreeNode> path1 = new ArrayList<>(), path2 = new ArrayList<>();
        getPath(root, p, path1);
        getPath(root, q, path2);
        TreeNode parent = null;

        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) break;
            parent = path1.get(i);
        }
        return parent;
    }

    private static boolean getPath(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == node) return true;

        path.add(root);
        if (root.left != null && getPath(root.left, node, path)) return true;
        if (root.right != null && getPath(root.right, node, path)) return true;
        path.remove(path.size() - 1);
        return false;
    }
}
