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

public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);

        return sb.toString();
    }
    public void helper(TreeNode root, StringBuilder sb)
    {
        
        if (root == null)
        {
            sb.append("n,");
            return;
        }

        sb.append(root.val).append(",");
        helper(root.left, sb);
        helper(root.right, sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        return dehelper(s);
    }

    int index = 0;
    public TreeNode dehelper(String[] s)
    {
        String value = s[index];
        index++;

        if (value.equals("n"))
            return null;
        
        TreeNode node = new TreeNode(Integer.parseInt(value));

        node.left = dehelper(s);
        node.right = dehelper(s);

        return node;
    }
}
