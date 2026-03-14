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
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null) {
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode mid=getMid(head);
        ListNode nextNode=mid.next;
        mid.next=null;
        ListNode firstHead=head;
        ListNode secondHead=reverse(nextNode);
        ListNode temp1=firstHead;
        ListNode temp2=secondHead;
        while(temp2!=null){
            ListNode nextNode1=temp1.next;
            temp1.next=temp2;
            temp1=nextNode1;
            ListNode nextNode2=temp2.next;
            temp2.next=temp1;
            temp2=nextNode2;
        }
        
    }
}