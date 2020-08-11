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
    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.right == null && root.left == null))
            return true;
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);
        if(!(left && right))
            return false;
        int largestSmaller = largestSmaller(root.left);
        if(root.left != null && largestSmaller >= root.val)
            return false;
        int smallestLarger = smallestLarger(root.right);
        if(root.right != null && smallestLarger <= root.val)
            return false;
        return true;
    }
    
    public static int largestSmaller(TreeNode node) {
        if(node == null)
            return 0;
        if(node.right == null)
            return node.val;
        return largestSmaller(node.right);
    }
    
    public static int smallestLarger(TreeNode node) {
        if(node == null)
            return 0;
        if(node.left == null)
            return node.val;
        return smallestLarger(node.left);
    }
}