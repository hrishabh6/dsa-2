package bst;

import binary_trees.traversal.TreeNode;

public class NodeInsert {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode curr = root;
        TreeNode prev = null;
        if (root == null) return new TreeNode(val);
        while(curr != null){
            if(curr.val > val){
                prev = curr;
                curr = curr.left;
            }
            else{
                prev = curr;
                curr = curr.right;
            }
        }
        curr = new TreeNode(val);
        if (prev.val > val) prev.left = curr;
        else prev.right = curr;
        return root;
    }

}
