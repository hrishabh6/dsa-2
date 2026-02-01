package binary_trees.medium;

import binary_trees.traversal.TreeNode;

public class Symmetry {

    public boolean isSymmetric(TreeNode root) {
        return root == null || checkSymmetry(root.left, root.right);
    }

    private boolean checkSymmetry(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return checkSymmetry(left.left, right.right) && checkSymmetry(left.right, right.left);
    }

}
