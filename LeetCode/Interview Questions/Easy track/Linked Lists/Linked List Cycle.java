/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;

public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> h = new HashSet();
        while(head != null) {
            if(h.contains(head))
                return true;
            h.add(head);
            head = head.next;
        }
        return false;
    }
}