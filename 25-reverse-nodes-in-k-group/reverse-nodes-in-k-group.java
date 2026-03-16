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
    static ListNode ohead;
    static ListNode otail;
    static ListNode thead;
    static ListNode ttail;
    public void addFirst(ListNode newNode) {
        // ListNode newNode = new ListNode(val);
        if(thead==null) {
            thead=newNode;
            ttail=newNode;
        }
        else {
            newNode.next=thead;
            thead=newNode;
        }
    }
    public int getSize(ListNode head) {
        int size=0;
        ListNode temp=head;
        while(temp != null) {
            temp=temp.next;
            size++;
        }
        return size;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
         ohead=null;
         otail=null;
         thead=null;
         ttail=null;
         int size=getSize(head);
         ListNode curr=head;
         while(size >= k) {
            for(int i=0;i<k;i++) {
                ListNode nextNode=curr.next;
                curr.next=null;
                addFirst(curr);
                curr=nextNode;
                size--;
            }
            if(ohead==null) {
               ohead=thead;
               otail=ttail;
            }
            else {
               otail.next=thead;
               otail=ttail;
            }
            thead=null;
            ttail=null;
         }
        otail.next=curr;
        return ohead;
    }
}