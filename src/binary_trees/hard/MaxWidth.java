package binary_trees.hard;

import binary_trees.traversal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x;
    TreeNode node;
    Pair(int x, TreeNode node) {
        this.x = x;
        this.node = node;
    }
}

public class MaxWidth {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int ans =  0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));
        while (!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().x;
            int first = 0, last = 0;
            for(int i = 0; i < size; i++) {
                assert q.peek() != null;
                int curr = q.peek().x - mmin;
                TreeNode node = q.poll().node;
                if(i == 0) first = curr;
                if (i ==  size - 1) last = curr;
                if(node.left != null) q.offer(new Pair(2 * curr + 1, node.left));
                if(node.right != null) q.offer(new Pair(2 * curr + 2, node.right));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }


}
