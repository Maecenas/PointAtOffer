package PointAtOffer;

import PointAtOffer.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Recursive/Iterative Pre- /In- /Post-order and Level-order Tree Traversal
 */
public class Q07_TraversalOfBinaryTree {

    /**
     * Root-Left-Right
     */
    public static List<Integer> preorderRecursively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;

        list.add(node.val);
        list.addAll(preorderRecursively(node.left));
        list.addAll(preorderRecursively(node.right));
        return list;
    }

    /**
     * Left-Root-Right
     */
    public static List<Integer> inorderRecursively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;

        list.addAll(preorderRecursively(node.left));
        list.add(node.val);
        list.addAll(preorderRecursively(node.right));
        return list;
    }

    /**
     * Left-Right-Root
     */
    public static List<Integer> postorderRecursively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;

        list.addAll(preorderRecursively(node.left));
        list.addAll(preorderRecursively(node.right));
        list.add(node.val);
        return list;
    }

    public static List<Integer> preorderIteratively(TreeNode<Integer> node) {
        List<Integer> list = new LinkedList<>();
        if (node == null) return list;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> curr = node;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                list.add(curr.val);  // Add before going to children
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop().right;
            }
        }
        return list;
    }

    public static List<Integer> inorderIteratively(TreeNode<Integer> node) {
        List<Integer> list = new LinkedList<>();
        if (node == null) return list;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> curr = node;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                list.add(curr.val);  // Add after all left children
                curr = curr.right;
            }
        }
        return list;
    }

    public static List<Integer> postorderIteratively(TreeNode<Integer> node) {
        LinkedList<Integer> list = new LinkedList<>();
        if (node == null) return list;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> curr = node;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                list.addFirst(curr.val);  // Reverse the process of post-order
                curr = curr.right;        // Reverse the process of post-order
            } else {
                curr = stack.pop().left;  // Reverse the process of post-order
            }
        }
        return list;
    }
}
