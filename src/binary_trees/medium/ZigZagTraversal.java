package binary_trees.medium;

import binary_trees.traversal.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (leftToRight) {
                    assert curr != null;
                    level.add(curr.val);
                } else {
                    assert curr != null;
                    level.add(0, curr.val);
                }

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;
    }

}
