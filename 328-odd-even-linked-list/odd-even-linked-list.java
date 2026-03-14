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
    public ListNode oddEvenList(ListNode head) {
        ListNode evenPosDummy=new ListNode(-1);
        ListNode oddPosDummy=new ListNode(-1);
        ListNode evenPosCurr=evenPosDummy;
        ListNode oddPosCurr=oddPosDummy;
        ListNode curr=head;
        int pos=0;
        while(curr!=null) {
            ListNode nextNode=curr.next;
            curr.next=null;
            if(pos%2==0) {
                evenPosCurr.next=curr;
                evenPosCurr=evenPosCurr.next;
            }
            else {
                oddPosCurr.next=curr;
                oddPosCurr=oddPosCurr.next;
            }
            curr=nextNode;
            pos++;
        }
        evenPosCurr.next=oddPosDummy.next;
        return evenPosDummy.next;
    }
}