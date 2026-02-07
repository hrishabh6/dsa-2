package bst;

import binary_trees.traversal.TreeNode;

public class Search {

    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = root.val > val ? root.left : root.right;
        }
        return root;

    }

    public int findMax(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}
