package bst;

import binary_trees.traversal.TreeNode;

public class ConstructBst {

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    //Here i is the pointer to the preorder array
    public TreeNode bstFromPreorder(int[] preorder, int bound, int[] i){
        if (i[0] == preorder.length || preorder[i[0]] > bound) return null;
        TreeNode root = new TreeNode(preorder[i[0]++]);

        root.left = bstFromPreorder(preorder, root.val, i);
        root.right = bstFromPreorder(preorder, bound, i);
        return root;
    }

}
