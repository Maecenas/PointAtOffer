package PointAtOffer;

import PointAtOffer.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Re-construction of binary tree from several tree traversal results.
 */
public class Q08_ConstructBinaryTree {

    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public static TreeNode<Integer> construct(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return constructCore(preorder, 0, inorder, 0, preorder.length);
    }

    private static TreeNode<Integer> constructCore(int[] preorder, int preorder_start, int[] inorder, int inorder_start, int len) {
        if (len == 0) return null;

        int inorder_index = -1;
        for (int i = inorder_start; i < inorder_start + len; i++) {
            if (inorder[i] == preorder[preorder_start]) {
                inorder_index = i;
                break;
            }
        }
        int left_length = inorder_index - inorder_start;
        TreeNode<Integer> node = new TreeNode<>(preorder[preorder_start]);
        node.left = constructCore(preorder, preorder_start + 1, inorder, inorder_start, left_length);
        node.right = constructCore(preorder, preorder_start + left_length + 1, inorder, inorder_index + 1, len - left_length - 1);
        return node;
    }
}
