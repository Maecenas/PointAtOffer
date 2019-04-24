package PointAtOffer;

import PointAtOffer.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q35_PrintTreeInLines {

    public static List<List<?>> print(TreeNode<?> root) {
        List<List<?>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode<?>> q = new LinkedList<>();
        q.offer(root);
        TreeNode<?> node;
        while (!q.isEmpty()) {
            List<Object> list = new ArrayList<>();
            for (int size = q.size(); size > 0; size--) {
                node = q.poll();
                if (node == null) continue;
                list.add(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
            if (!list.isEmpty()) res.add(list);
        }
        return res;
    }
}
