package binary_trees.medium;

import binary_trees.traversal.TreeNode;

import java.util.*;


class Pair2 {
    //This will hold the node seen at a particular level
    int x;
    TreeNode node;
    Pair2(int x, TreeNode node) {
        this.x = x;
        this.node = node;
    }
}


public class BottomView {

    public ArrayList<Integer> bottomView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Pair2> q = new LinkedList<>();
        q.offer(new Pair2(0, root));
        // TreeMap keeps keys sorted
        Map<Integer, Integer> map = new TreeMap<>();

        while (!q.isEmpty()) {
            Pair2 curr = q.poll();
            int x = curr.x;
            TreeNode node = curr.node;

            map.put(x, node.val);

            if (node.left != null) {
                q.offer(new Pair2(x - 1, node.left));
            }
            if (node.right != null) {
                q.offer(new Pair2(x + 1, node.right));
            }
        }

        // TreeMap guarantees left-to-right order
        for (int value : map.values()) {
            ans.add(value);
        }

        return ans;

    }

}
