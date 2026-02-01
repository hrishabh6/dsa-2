package binary_trees.hard;

import binary_trees.traversal.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class InfectedTree {

    public TreeNode markParent(TreeNode node, Map<TreeNode, TreeNode> map, int start){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        TreeNode startingNode = null;
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if (curr.val == start){startingNode = curr;}
            if (curr.left != null){
                map.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if (curr.right != null){
                map.put(curr.right, curr);
                queue.offer(curr.right);
            }

        }
        return startingNode;

    }

    public int amountOfTime(TreeNode root, int start) {
        //Steps :
        //Do a BFS traversal. in that mark the parent node of each node, while searching for start simultaneously
        // After this we have parent pointers with starting node. Then perform another BFS.
        // In second bfs, we do radialy outward movement for each node present in the queue. and increasing the count of time simultanneously.
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode startingNode = markParent(root, map, start);
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(startingNode, true);
        queue.offer(startingNode);
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            Boolean isInfected = false;
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                //Infect the left node if not infected already
                if (curr.left != null && visited.get(curr.left) == null){
                    queue.offer(curr.left);
                    visited.put(curr.left, true);
                    isInfected = true;
                }
                //Infect the right node if not infected already
                if (curr.right != null && visited.get(curr.right) == null){
                    queue.offer(curr.right);
                    visited.put(curr.right, true);
                    isInfected = true;
                }
                //Infect the parent node if not infected already
                if (map.get(curr) != null && visited.get(map.get(curr)) == null){
                    queue.offer(map.get(curr));
                    visited.put(map.get(curr), true);
                    isInfected = true;
                }
                //Increase time only if anything is infected
                if (isInfected) time++;
            }

        }
        return time;

    }

}
