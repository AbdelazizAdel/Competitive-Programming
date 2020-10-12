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
    int idx;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        preOrder(root, s);
        s.deleteCharAt(s.length() - 1);
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return reconstruct(nodes);
    }
    
    public void preOrder(TreeNode root, StringBuilder s) {
        if(root == null)
            s.append("null,");
        else {
            s.append(root.val + ",");
            preOrder(root.left, s);
            preOrder(root.right, s);
        }
    }
    
    public TreeNode reconstruct(String[] arr) {
        if(idx > arr.length || arr[idx].equals("null")) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx++]));
        root.left = reconstruct(arr);
        root.right = reconstruct(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));