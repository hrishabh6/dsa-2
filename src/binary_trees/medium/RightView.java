package binary_trees.medium;

import binary_trees.traversal.TreeNode;

import java.util.*;


class Pair3 {
    //This will hold the node seen at a particular level
    int x;
    TreeNode node;
    Pair3(int x, TreeNode node) {
        this.x = x;
        this.node = node;
    }
}


public class RightView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(i == size - 1) ans.add(curr.val);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
        }
        return ans;

    }

}
