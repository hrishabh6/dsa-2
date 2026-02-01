package binary_trees.hard;

import binary_trees.traversal.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree2 {

    //Construct a binary tree from inorder and postorder traversal
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);

    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd, Map<Integer, Integer> map){
        if (inStart > inEnd){
            return null;
        }
        //Here postEnd will be the root. and in prev question preStart was the root.
        //This is the core difference, everything else is same algo
        int rootVal = postOrder[postEnd];
        int rootIndex = map.get(rootVal);
        int leftSize = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, inStart, rootIndex - 1, postOrder, postStart, postStart + leftSize - 1, map);
        root.right = buildTree(inorder, rootIndex + 1, inEnd, postOrder, postStart + leftSize, postEnd - 1, map);
        return root;
    }

}
