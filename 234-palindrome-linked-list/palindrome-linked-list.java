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
    // find the mid and after that we need to split the linkedlist into two parts 
    // 0 to mid -> 1 part and mid+1 to end -> 2 part
    // compare each of the corresponding value in two linkedlists
    // if the values are not equal then retore the original ll and then retur false
    // else finally restore the original linkedlist and return true
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
    public boolean isPalindrome(ListNode head) {
        ListNode mid=getMid(head);
        ListNode nextNode=mid.next;
        mid.next=null;
        ListNode firstHead=head;
        ListNode secondHead=reverse(nextNode);
        ListNode temp1=firstHead;
        ListNode temp2=secondHead;
        while(temp2!=null) {
            if(temp1.val!=temp2.val) {
                nextNode=reverse(secondHead);
                mid.next=nextNode;
                return false;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        nextNode=reverse(secondHead);
        mid.next=nextNode;
        return true;
    }
}