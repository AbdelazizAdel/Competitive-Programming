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
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        cur = head;
        for(int i = 0; i < len / 2; i++)
            cur = cur.next;
        cur = reverseList(cur);
        for(int i = 0; i < len / 2; i++)
            if(head.val != cur.val)
                return false;
            else {
                head = head.next;
                cur = cur.next;
            }
        return true;
    }
    
    public static ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode prev = null, after = head.next;
        while(head != null){
            head.next = prev;
            prev = head;
            head = after;
            if(after != null)
                after = after.next;
        }
        return prev;
    }
}