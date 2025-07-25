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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        preorderHelper(root,result);
        return result;
    }
    private void preorderHelper(TreeNode node,List<Integer> list)
    {
        if(node==null) return;
        list.add(node.val); //root
        preorderHelper(node.left,list);//left
        preorderHelper(node.right,list);//right

    }
}
