package binary_trees.hard;

import binary_trees.traversal.TreeNode;

import java.util.*;

public class NodeAtDistanceK {

    void markParent(TreeNode node, Map<TreeNode, TreeNode> map){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if (curr.left != null){
                map.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if (curr.right != null){
                map.put(curr.right, curr);
                queue.offer(curr.right);
            }

        }
    }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        markParent(root, map);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if (curr_level == k) break;
            curr_level++;
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if (temp.left != null && visited.get(temp.left) == null) {
                    queue.offer(temp.left);
                    visited.put(temp.left, true);
                }
                if (temp.right != null && visited.get(temp.right) == null) {
                    queue.offer(temp.right);
                    visited.put(temp.right, true);
                }
                if (map.get(temp)!= null && visited.get(map.get(temp)) == null){
                    queue.offer(map.get(temp));
                    visited.put(map.get(temp), true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            ans.add(queue.poll().val);
            if (queue.isEmpty()) break;
        }
        return ans;

    }

}
