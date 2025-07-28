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
    int postindex;
    Map<Integer,Integer> inmap=new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postindex=postorder.length-1;
        for(int i=0;i<inorder.length;i++)
        {
            inmap.put(inorder[i],i);
        }
        return build(postorder,0,inorder.length-1);
    }
    private TreeNode build(int[] postorder,int instart,int inend)
    {
        if(instart>inend) return null;

        int rootval=postorder[postindex--];
        TreeNode root=new TreeNode(rootval);
        int inindex=inmap.get(rootval);

        root.right=build(postorder,inindex+1,inend);
        root.left=build(postorder,instart,inindex-1);
        return root;
    }
}
