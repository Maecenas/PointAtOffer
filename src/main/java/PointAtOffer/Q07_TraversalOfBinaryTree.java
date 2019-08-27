package PointAtOffer;

import PointAtOffer.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

        list.addAll(inorderRecursively(node.left));
        list.add(node.val);
        list.addAll(inorderRecursively(node.right));
        return list;
    }

    /**
     * Left-Right-Root
     */
    public static List<Integer> postorderRecursively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;

        list.addAll(postorderRecursively(node.left));
        list.addAll(postorderRecursively(node.right));
        list.add(node.val);
        return list;
    }

    public static List<Integer> preorderIteratively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;

        Stack<TreeNode<Integer>> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                list.add(node.val);  // Add before going to children
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop().right;
            }
        }
        return list;
    }

    public static List<Integer> inorderIteratively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;

        Stack<TreeNode<Integer>> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                list.add(node.val);  // Add after all left children
                node = node.right;
            }
        }
        return list;
    }

    public static List<Integer> postorderIteratively(TreeNode<Integer> node) {
        LinkedList<Integer> list = new LinkedList<>();
        if (node == null) return list;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> curr;

        stack.push(node);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            list.addFirst(curr.val);

            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        return list;
    }

    /**
     * BFS using queue
     */
    public static List<Integer> levelorder(TreeNode<Integer> node) {
        List<Integer> list = new LinkedList<>();
        if (node == null) return list;

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        TreeNode<Integer> curr;

        q.offer(node);
        while (!q.isEmpty()) {
            curr = q.poll();
            list.add(curr.val);

            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
        return list;
    }

}
