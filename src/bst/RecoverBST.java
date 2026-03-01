package bst;

import binary_trees.traversal.TreeNode;

public class RecoverBST {

    private TreeNode first = null;
    private TreeNode middle = null;
    private TreeNode prev = null;
    private TreeNode last = null;

    private void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);
        //If this is first violation
        //mark these as first and the middle
        if(prev != null && (root.val < prev.val)){
            if (first == null) {
                first = prev;
                middle = root;
            }
            //If this is second violation
            // mark this node as last
            else last = root;
        }
        //Mark this node as previous
        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

}
