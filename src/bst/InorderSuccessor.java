package bst;

import binary_trees.traversal.TreeNode;

import java.util.ArrayList;

public class InorderSuccessor {

    public ArrayList<TreeNode> findPreSuc(TreeNode root, int key) {

        TreeNode curr = root;
        TreeNode predecessor = null;
        TreeNode successor = null;

        while (curr != null) {

            if (curr.val < key) {
                predecessor = curr;
                curr = curr.right;
            }
            else if (curr.val > key) {
                successor = curr;
                curr = curr.left;
            }
            else {

                // Find predecessor (max in left subtree)
                if (curr.left != null) {
                    TreeNode temp = curr.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    predecessor = temp;
                }

                // Find successor (min in right subtree)
                if (curr.right != null) {
                    TreeNode temp = curr.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    successor = temp;
                }

                break;
            }
        }

        ArrayList<TreeNode> ans = new ArrayList<>();
        ans.add(predecessor);
        ans.add(successor);
        return ans;
    }


}
