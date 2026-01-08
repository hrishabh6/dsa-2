package binary_trees.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class LevelorderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                assert q.peek() != null;
                if (q.peek().left != null) q.offer(q.peek().left);
                assert q.peek() != null;
                if (q.peek().right != null) q.offer(q.peek().right);
                level.add(Objects.requireNonNull(q.poll()).val);
            }
            ans.add(level);
        }

        return ans;
    }

}