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
    static int preIdx;
    static HashMap<Integer, Integer> map;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        map = new HashMap();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return helper(0, inorder.length - 1, preorder, inorder);
    }
    
    public static TreeNode helper(int s, int e, int[] pre, int[] in) {
        if(s > e)
            return null;
        TreeNode node = new TreeNode(pre[preIdx++]);
        int inIdx = map.get(node.val);
        node.left = helper(s, inIdx - 1, pre, in);
        node.right = helper(inIdx + 1, e, pre, in);
        return node;
        
    }
    
}