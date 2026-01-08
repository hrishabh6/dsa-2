package binary_trees.medium;

import binary_trees.traversal.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

public class BoundaryTraversal {

    ArrayList<Integer> boundaryTraversal(TreeNode root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (!isLeaf(root)) ans.add(root.val);
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }

    private void addLeftBoundary(TreeNode root, ArrayList<Integer> ans){
        TreeNode curr = root.left;
        while(curr != null){
            if (!isLeaf(curr)) {
                ans.add(curr.val);
            }
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    private void addRightBoundary(TreeNode root, ArrayList<Integer> ans){
        TreeNode curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr != null){
            if (!isLeaf(curr)) {
                temp.add(curr.val);
            }
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        int i;
        for (i = temp.size()-1; i >= 0; i--) ans.add(temp.get(i));
    }
    private void addLeaves(TreeNode root, ArrayList<Integer> ans){
        //Perform inorder traversal and add leaves
        if (isLeaf(root)) {
            ans.add(root.val);
            return;
        }
        if (root.left != null) addLeaves(root.left, ans);
        if (root.right != null) addLeaves(root.right, ans);
    }
    private boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }

}
