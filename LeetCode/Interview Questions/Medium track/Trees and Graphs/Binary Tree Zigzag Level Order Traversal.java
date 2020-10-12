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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if(root == null)
            return list;
        boolean lr = true;
        List<TreeNode> level = new ArrayList();
        level.add(root);
        while(!level.isEmpty()) {
            List<Integer> l = new ArrayList();
            if(lr)
                for(int i = 0; i < level.size(); i++)
                    l.add(level.get(i).val);
            else
                for(int i = level.size() - 1; i >= 0; i--)
                    l.add(level.get(i).val);
            list.add(l);
            List<TreeNode> l2 = new ArrayList();
            for(int i = 0; i < level.size(); i++) {
                if(level.get(i).left != null)
                    l2.add(level.get(i).left);
                if(level.get(i).right != null)
                    l2.add(level.get(i).right);
            }
            level = l2;
            lr = !lr;
        }
        return list;
    }
}