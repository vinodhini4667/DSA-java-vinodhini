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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        dfs(root,targetSum,path,result);
        return result;
    }
    private void dfs(TreeNode node,int sum,List<Integer> path,List<List<Integer>> result)
    {
        if(node==null) return;

        path.add(node.val);
        sum-=node.val;
        // If it's a leaf and sum is 0, we found a valid path
        if(node.left==null && node.right==null && sum==0)
        {
            result.add(new ArrayList<>(path));
        }
        dfs(node.left,sum,path,result);
        dfs(node.right,sum,path,result);
        // Backtrack
        path.remove(path.size()-1);

    }
}
