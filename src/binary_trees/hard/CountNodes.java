package binary_trees.hard;

import binary_trees.traversal.TreeNode;

public class CountNodes {

    public int getLeftHeight(TreeNode root){
        int count = 0;
        while(root != null){
            root = root.left;
            count++;
        }
        return count;
    }

    public int getRightHeight(TreeNode root){
        int count = 0;
        while(root != null){
            root = root.right;
            count++;
        }
        return count;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lh = getLeftHeight(root.left);
        int rh = getRightHeight(root.right);
        //2^tree level - 1 formula for number of node in perfect tree
        // if left height == right height, that means the tree is a perfect tree
        if (lh == rh) return ((2 << lh) - 1);
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}
