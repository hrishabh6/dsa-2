package binary_trees.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private void helper(TreeNode root, List<Integer> ans){
        if (root == null) return;
        helper(root.left, ans);
        helper(root.right, ans);
        ans.add(root.val);
    }

    //Iterative solution
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            if (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    ans.add(temp.val);
                    while (!stack.isEmpty() && stack.peek().right == temp) {
                        temp = stack.pop();
                        ans.add(temp.val);
                    }
                } else {
                    curr = temp;
                }
            }
        }
        return ans;
    }

}
