package PointAtOffer;

import PointAtOffer.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q38_FindPath {

    public static List<List<Integer>> findPath(TreeNode<Integer> root, int target) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        backtracking(root, target, res, new ArrayList<>());
        return res;
    }

    private static void backtracking(final TreeNode<Integer> node, int target, final List<List<Integer>> res, final List<Integer> path) {
        if (node == null) return;
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(path));
        } else {
            backtracking(node.left, target, res, path);
            backtracking(node.right, target, res, path);
        }
        path.remove(path.size() - 1);
    }
}
