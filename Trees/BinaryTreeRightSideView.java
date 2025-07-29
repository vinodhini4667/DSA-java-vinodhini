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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null)  return result;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int size=q.size();
            TreeNode rightmost=null;
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                if(curr!=null)
                {
                    rightmost=curr;
                    if(curr.left!=null) q.offer(curr.left);
                    if(curr.right!=null) q.offer(curr.right);

                }

            }
            if(rightmost!=null)
            {
                result.add(rightmost.val);
            }
        }
        return result;
    }
}
