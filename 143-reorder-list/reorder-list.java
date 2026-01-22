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
    public ListNode middleOfLinkedList(ListNode head) {
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
        ListNode middle=middleOfLinkedList(head);
        ListNode nextNode=middle.next;
        ListNode secondHead=reverse(nextNode);
        middle.next=null;
        ListNode dummyNode=new ListNode(-1);
        ListNode curr=dummyNode;
        ListNode temp1=head;
        ListNode temp2=secondHead;
        while(temp2!=null) {
             curr.next=temp1;
             temp1=temp1.next;
             curr=curr.next;
             curr.next=temp2;
             temp2=temp2.next;
             curr=curr.next;
        }
        curr.next=temp1;
        // return dummyNode.next;
    }
}