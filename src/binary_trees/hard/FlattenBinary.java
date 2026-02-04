package binary_trees.hard;

import binary_trees.traversal.TreeNode;

public class FlattenBinary {

    static TreeNode prev = null;

    public void flatten(TreeNode root) {
        prev = null;
        helper(root);
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.right);
        helper(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}
