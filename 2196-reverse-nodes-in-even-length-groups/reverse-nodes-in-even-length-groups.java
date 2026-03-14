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
    public void addLast(ListNode node) {
        if(thead==null) {
            thead=node;
            ttail=node;
        }
        else {
            ttail.next=node;
            ttail=node;
        }
    }
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ohead=null;
        otail=null;
        thead=null;
        ttail=null;
        int size=getSize(head);
        int curr_grp_size=1;
        ListNode curr=head;
        while(size >= curr_grp_size) {
            int K=curr_grp_size;
            for(int i=0;i<K;i++) {
                ListNode nextNode=curr.next;
                curr.next=null;
                if(curr_grp_size % 2==0) {
                    addFirst(curr);
                }
                else {
                    addLast(curr);
                }
                curr=nextNode;
            }
            if(ohead == null) {
                ohead=thead;
                otail=ttail;
            }
            else {
               otail.next=thead;
               otail=ttail;
            }
            thead=null;
            ttail=null;
            size -= curr_grp_size;
            curr_grp_size++;
        }
        while(curr != null) {
            ListNode nextNode=curr.next;
            curr.next=null;
            if(size % 2==0) {
                addFirst(curr);
            } 
            else {
                addLast(curr);
            }
            curr=nextNode;
        }
        otail.next=thead;
        otail=ttail;
        return ohead;
    }
}