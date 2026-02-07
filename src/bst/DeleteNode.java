package bst;

import binary_trees.traversal.TreeNode;

public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) return helper(root);
        TreeNode temp = root;
        while(root != null){
            if(root.val > key){
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                }
                else root = root.left;
            }
            else{
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else root = root.right;
            }
        }
        return temp;
    }

    private TreeNode helper(TreeNode root){
        if(root.left == null) {
            return root.right;
        }
        else if (root.right == null) {
            return root.left;
        }

        TreeNode rightChild = root.right;
        TreeNode farthestRightChild = findRight(rightChild);
        farthestRightChild.right = root.right;
        return root.left;
    }
    private TreeNode findRight(TreeNode root){
        while(root.right != null) {
            root = root.right;
        }
        return root;
    }

}
