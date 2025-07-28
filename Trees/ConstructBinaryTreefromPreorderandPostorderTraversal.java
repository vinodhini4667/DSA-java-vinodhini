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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode build(int[] pre,int prestart,int preend,int[] post,int poststart,int postend)
    {
        if(prestart>preend || poststart>postend)
        {
            return null;
        }
        TreeNode root=new TreeNode(pre[prestart]);
        if(prestart==preend) return root;

        int leftrootval=pre[prestart+1];
        int index=poststart;
        while(post[index]!=leftrootval) index++;
        int len=index-poststart+1;

        root.left=build(pre,prestart+1,prestart+len,post,poststart,index);
        root.right=build(pre,prestart+len+1,preend,post,index+1,postend-1);
        return root;
    }
}
