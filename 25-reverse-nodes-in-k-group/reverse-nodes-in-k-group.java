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
    ListNode ohead;
    ListNode otail;
    ListNode thead;
    ListNode ttail;
    public int getSize(ListNode head) {
        ListNode temp=head;
        int size=0;
        while(temp!=null) {
            temp=temp.next;
            size++;
        }
        return size;
    }
    public void addFirst(ListNode node) {
        if(thead==null) {
            thead=node;
            ttail=node;
        }
        else {
            node.next=thead;
            thead=node;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ohead=null;
        otail=null;
        thead=null;
        ttail=null;
        int size=getSize(head);
        ListNode curr=head;
        while(size>=k) {
            int K=k;
            while(K-->0) {
               ListNode nextNode=curr.next;
               curr.next=null;
               addFirst(curr);
               size--;
               curr=nextNode;
            }
            // this is for creating the first original list
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