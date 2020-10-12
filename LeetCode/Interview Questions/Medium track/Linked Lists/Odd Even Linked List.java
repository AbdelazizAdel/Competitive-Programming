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
    public ListNode oddEvenList(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        if(len < 3)
            return head;
        cur = head;
        ListNode temp = cur.next, even_start = cur.next, odd_end = head;
        while(temp != null) {
            cur.next = temp.next;
            if(temp.next == null) {
                if(len % 2 == 0)
                    odd_end = cur;
                else
                    odd_end = temp;
            }
            cur = temp;
            temp = temp.next;
        }
        odd_end.next = even_start;
        return head;
    }
}