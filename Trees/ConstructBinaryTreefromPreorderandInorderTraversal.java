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
    int preindex=0;
    Map<Integer,Integer> inmap=new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++)
        {
            inmap.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);
    }

    private TreeNode build(int[] preorder,int instart,int inend)
    {
        if(instart>inend) return null;

        int rootval=preorder[preindex++];
        TreeNode root=new TreeNode(rootval);

        int inindex=inmap.get(rootval);

        root.left=build(preorder,instart,inindex-1);
        root.right=build(preorder,inindex+1,inend);
        return root;
    }
}
