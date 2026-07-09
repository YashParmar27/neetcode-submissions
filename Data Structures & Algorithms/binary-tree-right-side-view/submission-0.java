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

    List<Integer> nodes = new ArrayList<>();
    public void helper(TreeNode node, int depth)
    {
        if (node == null)
            return;
        if (depth == nodes.size())
            nodes.add(node.val);
        
        helper(node.right, depth + 1);
        helper(node.left, depth + 1);
        return;
    }
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return nodes;
    }
}
