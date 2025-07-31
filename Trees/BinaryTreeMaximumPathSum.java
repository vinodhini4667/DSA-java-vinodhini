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
    private int maxsum=Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
       
        helper(root);
        return maxsum;
    }
    private int helper(TreeNode node)
    {
         if(node==null) return 0;

         int left=Math.max(0,helper(node.left));
         int right=Math.max(0,helper(node.right));

         maxsum=Math.max(maxsum,left+right+node.val);
         
        // Return the max gain if we continue the same path upward
        return Math.max(left,right)+node.val;
    }
}
