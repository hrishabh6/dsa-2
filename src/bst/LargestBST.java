package bst;

import binary_trees.traversal.TreeNode;

class NodeValue {
    int maxNode, minNode, maxSize;
    NodeValue(int maxNode, int minNode, int maxSize){
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize;
    }
}

public class LargestBST {
    private static NodeValue largestBstHelper(TreeNode root) {
        if (root == null){
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        NodeValue left = largestBstHelper(root.left);
        NodeValue right = largestBstHelper(root.right);

        if (left.maxNode < root.val && root.val < right.minNode) {
            return new NodeValue(
                    Math.max(root.val, right.maxNode),
                    Math.min(root.val, left.minNode),
                    1 + left.maxSize + right.maxSize
            );
        }

        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE,
                Math.max(left.maxSize, right.maxSize));
    }


    public int largestBst(TreeNode root){
        return largestBstHelper(root).maxSize;
    }


}
