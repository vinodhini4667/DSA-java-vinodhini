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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int leftheight=getheight(root.left);
        int rightheight=getheight(root.right);

        if(leftheight==rightheight)
        {
            // Left subtree is perfect
            return (1<< leftheight)+countNodes(root.right);
        }
        else
        {
            //right subtree is perfect
            return (1<< rightheight)+countNodes(root.left);
        }
    }

    public int getheight(TreeNode node)
    {
        int height=0;
        while(node!=null)
        {
            height++;
            node=node.left;
        }
        return height;
    }
}
