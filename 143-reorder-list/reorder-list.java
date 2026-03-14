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
    public void undo(ListNode head) {
        ListNode evenPosDummy=new ListNode(-1);
        ListNode oddPosDummy=new ListNode(-1);
        ListNode evenCurr=evenPosDummy;
        ListNode oddCurr=oddPosDummy;
        ListNode curr=head;
        int pos=0;
        while(curr!=null) {
           ListNode nextNode=curr.next;
           curr.next=null;
           if(pos%2==0) {
              evenCurr.next=curr;
              evenCurr=evenCurr.next;
           }
           else {
              oddCurr.next=curr;
              oddCurr=oddCurr.next;
           }
           curr=nextNode;
           pos++;
        }
       ListNode oddPosHead=oddPosDummy.next;
       oddPosDummy.next=null;
       ListNode midNext=reverse(oddPosHead);
       evenCurr.next=midNext;
    }
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
    public void reorderList1(ListNode head) {
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
     public void reorderList(ListNode head) {
        reorderList1(head);
        undo(head);
        reorderList1(head);
    }
}