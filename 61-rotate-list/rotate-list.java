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
    public int getSize(ListNode head) {
        int size=0;
        ListNode temp=head;
        while(temp != null) {
            temp=temp.next;
            size++;
        }
        return size;
    }
    public ListNode getNodeAt(ListNode head,int idx) {
        ListNode temp=head;
        for(int i=1;i<idx;i++) {
            temp=temp.next;
        }
        return temp;
    }
    public ListNode reverse(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
        while(curr != null) {
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }
    public ListNode rotateRight(ListNode head, int k) {
         if(head==null) {
            return head;
         }
         int size=getSize(head);
         k=k % size;
         ListNode reqNode=getNodeAt(head,size-k);
         System.out.println(reqNode.val);
         ListNode nextNode=reqNode.next;
         if(nextNode==null) {
            return head;
         }
         reqNode.next=null;
        //  ListNode newHead=reverse(nextNode);
        ListNode temp=nextNode;
        while(temp.next!=null) {
            temp=temp.next;
        }
        temp.next=head;
        return nextNode;
    }
}