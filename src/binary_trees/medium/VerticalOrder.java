package binary_trees.medium;

import binary_trees.traversal.TreeNode;

import java.util.*;

class Tuple {
    TreeNode node;
    int x;
    int y;
    Tuple(TreeNode node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}


public class VerticalOrder {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //Here First Integer represents = Vertical (which vertical level we're on)
        //Then on that vertical Another treemap with Integer (which represents the horizontal level we're on)
        //And then a priority queue because on each Coordinate (Vertical, horizontal) we can have multiple node, and we need them in sorted order if we do.
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0, 0));
        while(!q.isEmpty()){
            Tuple curr = q.poll();
            TreeNode node = curr.node;
            int x = curr.x;
            int y = curr.y;
            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);
            if(node.left != null) q.offer(new Tuple(node.left, x-1, y+1));
            if(node.right != null) q.offer(new Tuple(node.right, x+1, y+1));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> treeMap : map.values()) {
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> priorityQueue : treeMap.values()) {
                while(!priorityQueue.isEmpty()){
                    ans.get(ans.size()-1).add(priorityQueue.poll());
                }
            }
        }
        return ans;
    }

}
