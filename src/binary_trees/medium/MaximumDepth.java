package binary_trees.medium;

import binary_trees.traversal.TreeNode;

public class MaximumDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return 1 + Math.max(lh, rh);
    }

}
