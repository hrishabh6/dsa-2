package binary_trees.hard;

import binary_trees.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    //Cover both inorder and preorder traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;

            }
            else{
                TreeNode predecessor = curr.left;
                while(predecessor.right != null && predecessor.right != curr) predecessor = predecessor.right;
                if (predecessor.right == null){
                    predecessor.right = curr;
                    curr = curr.left;
                }
                else{
                    ans.add(curr.val);
                    predecessor.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;

            }
            else{
                TreeNode predecessor = curr.left;
                while(predecessor.right != null && predecessor.right != curr) predecessor = predecessor.right;
                if (predecessor.right == null){
                    ans.add(curr.val);
                    predecessor.right = curr;
                    curr = curr.left;
                }
                else{

                    predecessor.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }

}
