package PointAtOffer;

import PointAtOffer.utils.TreeNode;

public class Q41_SerializeBinaryTrees {

    public static String serialize(TreeNode<Integer> root) {
        if (root == null) return "$,";

        StringBuilder str = new StringBuilder();
        str.append(root.val);
        str.append(",");
        str.append(serialize(root.left));
        str.append(serialize(root.right));

        return str.toString();
    }

    public static TreeNode<Integer> deserialize(String str) {
        StringBuilder sb = new StringBuilder(str);
        return deserialize(sb);
    }

    private static TreeNode<Integer> deserialize(StringBuilder str) {
        if (str.length() == 0) return null;

        final int lastIndex = str.indexOf(",");
        String val = str.substring(0, lastIndex);
        str.delete(0, lastIndex + 1);

        if (val.equals("$")) return null;
        TreeNode<Integer> node = new TreeNode<>(Integer.valueOf(val));
        node.left = deserialize(str);
        node.right = deserialize(str);
        return node;
    }
}
