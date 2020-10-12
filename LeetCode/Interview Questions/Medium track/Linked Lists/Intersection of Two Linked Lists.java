/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lA = 0, lB = 0;
        ListNode cur = headA;
        while(cur != null) {
            lA++;
            cur = cur.next;
        }
        cur = headB;
        while(cur != null) {
            lB++;
            cur = cur.next;
        }
        ListNode curA = headA, curB = headB;
        for(int i = 0; i < lA - lB; i++)
            curA = curA.next;
        for(int i = 0; i < lB - lA; i++)
            curB = curB.next;
        while(curA != null && curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA == curB ? curA : null;
    }
}