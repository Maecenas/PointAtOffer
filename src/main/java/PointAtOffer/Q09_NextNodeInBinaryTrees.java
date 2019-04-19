package PointAtOffer;

public class Q09_NextNodeInBinaryTrees {

    /**
     * TreeNode with parent pointer
     */
    static class TreeNode {

        int val;
        TreeNode left, right, parent;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode getNext(TreeNode node) {
        if (node == null) return null;

        if (node.right != null) {
            return node.right;
        } else {
            while (node.parent != null) {
                TreeNode parent = node.parent;
                if (parent.left == node) return parent;
                node = parent;
            }
        }
        return null;
    }
}
