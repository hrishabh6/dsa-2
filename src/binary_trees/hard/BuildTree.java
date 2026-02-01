package binary_trees.hard;

import binary_trees.traversal.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    //Construct a binary tree from preorder and inorder traversal
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;

    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map){
        if (preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRootIndex = map.get(root.val);
        int leftSize = inRootIndex - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, inRootIndex - 1, map);
        root.right = buildTree(preorder, preStart + leftSize + 1, preEnd, inorder, inRootIndex + 1, inEnd, map);
        return root;
    }


}
