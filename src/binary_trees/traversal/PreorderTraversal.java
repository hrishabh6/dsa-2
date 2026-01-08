package binary_trees.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private void helper(TreeNode root, List<Integer> ans){
        if(root == null) return;
        ans.add(root.val);
        helper(root.left, ans);
        helper(root.right, ans);
    }

    //Interative
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            ans.add(root.val);
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);

        }
        return ans;
    }

}
