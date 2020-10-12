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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, cur = null;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int a = 0, b = 0;
            if(l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            int v = a + b + carry;
            int sum = v % 10;
            carry = v / 10;
            if(head == null) {
                head = new ListNode(sum);
                cur = head;
            }
            else {
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
        }
        return head;
    }
}