package binary_trees.medium;

import binary_trees.traversal.TreeNode;

import java.util.*;

class Pair {
    //This will hold the node seen at a particular level
    int x;
    TreeNode node;
    Pair(int x, TreeNode node) {
        this.x = x;
        this.node = node;
    }
}

public class TopView {

    public ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));
        // TreeMap keeps keys sorted
        Map<Integer, Integer> map = new TreeMap<>();

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            TreeNode node = curr.node;

            // store only the first node encountered at this horizontal distance
            map.computeIfAbsent(x, k -> node.val);

            if (node.left != null) {
                q.offer(new Pair(x - 1, node.left));
            }
            if (node.right != null) {
                q.offer(new Pair(x + 1, node.right));
            }
        }

        // TreeMap guarantees left-to-right order
        for (int value : map.values()) {
            ans.add(value);
        }

        return ans;
    }


}
