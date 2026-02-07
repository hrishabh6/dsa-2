package bst;

import binary_trees.traversal.TreeNode;

public class LCA {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int curr = root.val;
        if (p.val > curr && q.val > curr) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (p.val < curr && q.val < curr){
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

}
