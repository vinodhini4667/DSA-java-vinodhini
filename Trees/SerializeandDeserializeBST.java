/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }
    public void preorder(TreeNode node,StringBuilder sb)
    {
        if(node==null) return;
        sb.append(node.val).append(",");
        preorder(node.left,sb);
        preorder(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;

        Queue<Integer> queue=new LinkedList<>();
        for(String s:data.split(","))
        {
             if(!s.isEmpty())
             {
                queue.offer(Integer.parseInt(s));
             }
             
        }
        return buildtree(queue,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public TreeNode buildtree(Queue<Integer> q,int lower,int upper)
    {
        if(q.isEmpty()) return null;

        int val=q.peek();
        if(val<lower || val>upper) return null;

        q.poll();
        TreeNode root=new TreeNode(val);
        root.left=buildtree(q,lower,val);
        root.right=buildtree(q,val,upper);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
