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
    public ListNode getMid(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null) {
            ListNode nextNode=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nextNode;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode mid=getMid(head);
        ListNode nextNode=mid.next;
        ListNode secondHead=reverse(nextNode);
        ListNode temp1=head;
        ListNode temp2=secondHead;
        while(temp2!=null) {
            if(temp1.val!=temp2.val) {
                return false;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return true;
    }
}