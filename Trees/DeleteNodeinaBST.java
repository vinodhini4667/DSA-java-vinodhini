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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

        if(key<root.val)
        {
            root.left=deleteNode(root.left,key);
        }
        else if(key>root.val)
        {
            root.right=deleteNode(root.right,key);
        }
        else
        {
            //node found

            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            
        // Node with two children → get inorder successor (smallest in right subtree)
        TreeNode minnode=findmin(root.right);
        root.val=minnode.val;
        root.right=deleteNode(root.right,minnode.val);
        }
        return root;

    }

    public TreeNode findmin(TreeNode node)
    {
        while(node.left!=null)
        {
            node=node.left;
        }
        return node;
    }
}
