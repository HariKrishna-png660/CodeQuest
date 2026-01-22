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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        // reverse the all the nodes that are after me then i will also add in reverse
        ListNode newNode=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }
}