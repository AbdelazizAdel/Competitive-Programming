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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack();
        HashSet<TreeNode> set = new HashSet();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(set.contains(node))
                list.add(node.val);
            else {
                if(node.right != null)
                    stack.push(node.right);
                stack.push(node);
                if(node.left != null)
                    stack.push(node.left);
                set.add(node);
            }
        }
        return list;
    }
}