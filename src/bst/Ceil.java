package bst;


import binary_trees.traversal.TreeNode;

public class Ceil {

    public int findCeil(TreeNode root, int x) {
        int ceil = -1;
        while (root != null) {
            if (root.val >= x) {
                ceil = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return ceil;
    }

    public int findFloor(TreeNode root, int x) {
       int floor = -1;
       while (root != null) {
           if(root.val <= x) {
               floor = root.val;
               root = root.right;
           }
           else root = root.left;
       }
       return floor;
    }

}
