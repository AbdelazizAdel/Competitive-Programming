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
import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if(root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList();
        HashMap<TreeNode, Integer> h = new HashMap();
        q.add(root);
        h.put(root, 0);
        ans.add(new ArrayList<Integer>());
        ans.get(0).add(root.val);
        while(!q.isEmpty()) {
            TreeNode u = q.poll();
            if(u.left != null){
                q.add(u.left);
                int dis = h.get(u) + 1;
                h.put(u.left, dis);
                if(dis == ans.size()){
                    ans.add(new ArrayList<Integer>());
                    ans.get(dis).add(u.left.val);
                }
                else
                    ans.get(dis).add(u.left.val);
            }
            if(u.right != null){
                q.add(u.right);
                int dis = h.get(u) + 1;
                h.put(u.right, dis);
                if(dis == ans.size()){
                    ans.add(new ArrayList<Integer>());
                    ans.get(dis).add(u.right.val);
                }
                else
                    ans.get(dis).add(u.right.val);
            }  
        }
        return ans;
    }
}