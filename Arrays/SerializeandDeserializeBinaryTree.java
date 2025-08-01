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
        if(root==null) return "null";
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes=data.split(",");
        Queue<String> q=new LinkedList<>(Arrays.asList(nodes));
        return buildtree(q);
    }
    public TreeNode buildtree(Queue<String> q)
    {
        String val=q.poll();
        if(val.equals("null")) return null;

        TreeNode node=new TreeNode(Integer.parseInt(val));

        node.left=buildtree(q);
        node.right=buildtree(q);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
