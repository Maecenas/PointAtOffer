package PointAtOffer;

import PointAtOffer.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q36_PrintTreeInZigzag {

    public static List<List<?>> print(TreeNode<?> root) {
        if (root == null) return new ArrayList<>();

        List<List<?>> res = new ArrayList<>();
        Queue<TreeNode<?>> q = new LinkedList<>();
        q.add(root);
        boolean needReverse = false;
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
            if (needReverse) Collections.reverse(list);
            needReverse = !needReverse;
            if (!list.isEmpty()) res.add(list);
        }
        return res;
    }
}
