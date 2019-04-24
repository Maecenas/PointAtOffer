package PointAtOffer;

import PointAtOffer.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q35_PrintTreeInLines {

    public static List<List<Object>> print(TreeNode<Object> root) {
        List<List<Object>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode<Object>> q = new LinkedList<>();
        q.offer(root);
        TreeNode<Object> node;
        while (!q.isEmpty()) {
            List<Object> list = new ArrayList<>();
            for (int size = q.size(); size > 0; size--) {
                node = q.poll();
                assert node != null;
                list.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
