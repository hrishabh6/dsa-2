package binary_trees.medium;

import binary_trees.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IdenticalTrees {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pList = inorderTraversal(p);
        List<Integer> qList = inorderTraversal(q);
        return pList.equals(qList);
    }

    //Do any traversal and match the result
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

}
