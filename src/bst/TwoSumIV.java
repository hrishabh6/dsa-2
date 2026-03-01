package bst;

import binary_trees.traversal.TreeNode;

import java.util.Stack;

class Iterator {

    private Stack<TreeNode> stack = new Stack<>();
    Boolean isReverse = true;

    public Iterator(TreeNode root, Boolean isReverse) {
        this.isReverse = isReverse;
        pushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        if (!isReverse) pushAll(node.right);
        else pushAll(node.left);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode node){
        while(node != null){
            stack.push(node);
            if (isReverse){
                node = node.right;
            }
            else node = node.left;
        }
    }
}


public class TwoSumIV {

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Iterator left = new Iterator(root, false);
        Iterator right = new Iterator(root, true);

        int i = left.next();
        int j = right.next();

        while(i < j) {
            if (i + j == k) return true;
            else if (i + j < k) i = left.next();
            else j = right.next();
        }
        return false;
    }

}
