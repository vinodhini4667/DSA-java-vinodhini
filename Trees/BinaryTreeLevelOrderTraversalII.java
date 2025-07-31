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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new LinkedList<>();
        if(root==null) return result;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int size=queue.size();
            List<Integer> level=new ArrayList<>();
            // process all nodes at current level
            for(int i=0;i<size;i++)
            {
                TreeNode current=queue.poll();
                level.add(current.val);

                if(current.left!=null)
                {
                    queue.offer(current.left);
                }
                if(current.right!=null)
                {
                    queue.offer(current.right);
                }
            }
            // add current level at the beginning of the result list
            result.add(0,level);
        }
        return result;
    }
}
