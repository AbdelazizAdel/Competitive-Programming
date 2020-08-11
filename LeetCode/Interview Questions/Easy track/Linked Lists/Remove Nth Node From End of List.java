/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode bef = head, cur = head;
        for(int i = 0; i < n; i++)
            cur = cur.next;
        if(cur == null){
            head = head.next;
            return head;
        }
        while(cur.next != null){
            bef = bef.next;
            cur = cur.next;
        }
        bef.next = bef.next.next;
        return head;
    }
}