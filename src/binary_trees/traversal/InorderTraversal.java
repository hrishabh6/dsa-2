package binary_trees.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private void helper(TreeNode root, List<Integer> ans){
        if(root == null) return;
        helper(root.left, ans);
        ans.add(root.val);
        helper(root.right, ans);
    }

    //Iterative solution
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(true){
            if (curr != null){
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty()) break;
                curr = stack.pop();
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        return ans;
    }

}
