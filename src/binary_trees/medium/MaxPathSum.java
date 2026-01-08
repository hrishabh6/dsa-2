package binary_trees.medium;

import binary_trees.traversal.TreeNode;

public class MaxPathSum {

        public int maxPathSum(TreeNode root) {
            int[] maximum = new int[1];
            maximum[0] = Integer.MIN_VALUE;
            helper(root, maximum);
            return maximum[0];
        }

        public int helper(TreeNode root, int[] maximum) {
            if (root == null) return 0;
            //Key point. as we either set it to zero or value because adding a negative val node wont help
            int lh = Math.max(0, helper(root.left, maximum));
            int rh = Math.max(0, helper(root.right, maximum));

            // Update global maximum with a path through this node
            maximum[0] = Math.max(maximum[0], root.val + lh + rh);

            // Return max one-sided path
            return root.val + Math.max(lh, rh);
        }


}
