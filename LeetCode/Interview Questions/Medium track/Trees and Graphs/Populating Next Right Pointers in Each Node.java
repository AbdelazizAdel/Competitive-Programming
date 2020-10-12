/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        helper(root.left, root.right, true);
        return root;
    }
    
    public static void helper(Node n1, Node n2, boolean flag) {
        if (n1 == null)
            return;
        n1.next = n2;
        if(flag)
            helper(n1.left, n1.right, true);
            helper(n2.left, n2.right, true);
            helper(n1.right, n2.left, false);
        }
}