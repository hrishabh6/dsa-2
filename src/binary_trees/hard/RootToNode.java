package binary_trees.hard;

import binary_trees.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RootToNode {

    public List<Integer> path(TreeNode root, int target){
        List<Integer> ans = new ArrayList<>();
        helper(root, target, ans);
        return ans;
    }

    private boolean helper(TreeNode root, int target, List<Integer> ans){
        if(root == null) return false;
        ans.add(root.val);
        if(root.val == target) return true;
        if (helper(root.left, target, ans) || helper(root.right, target, ans)) {
            return true;
        }
        //Backtracking
        ans.remove(ans.size() - 1);
        return false;
    }

}
