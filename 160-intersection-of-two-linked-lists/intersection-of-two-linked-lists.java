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
        ListNode temp=headA;
        while(temp.next != null) {
            temp=temp.next;
        }
        temp.next=headA;
        ListNode slow=headB;
        ListNode fast=headB;
        if(headB == null || headB.next ==null) {
            temp.next=null;
            return null;
        }
        while(fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) {
                break;
            }
        }
        if(slow != fast) {
            temp.next=null;
            return null;
        }
        slow=headB;
        while(slow != fast) {
            slow=slow.next;
            fast=fast.next;
        }
        temp.next=null;
        return slow;
    }
}