/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int max = Integer.MIN_VALUE;
    public int helper(TreeNode node)
    {
        if (node == null)
            return 0;
        int leftSum = Math.max(0,helper(node.left));
        int rightSum = Math.max(0,helper(node.right));

        max = Math.max(max, leftSum + rightSum + node.val);
    
        return node.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
}
