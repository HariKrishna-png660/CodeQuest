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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode dummyNode=new ListNode(-1);
        ListNode curr=dummyNode;
        int carry=0;
        while(temp1!=null && temp2!=null) {
             int sum=carry;
             sum += (temp1.val+temp2.val);
             if(sum>9) {
                sum=sum%10;
                carry=1;
             }
             else {
                carry=0;
             }
             ListNode newNode=new ListNode(sum);
             curr.next=newNode;
             curr=curr.next;
             temp1=temp1.next;
             temp2=temp2.next;
        }
        while(temp1!=null) {
            int sum=carry;
            sum += temp1.val;
            if(sum>9) {
                sum=sum%10;
                carry=1;
            }
            else {
                carry=0;
            }
            ListNode newNode=new ListNode(sum);
            curr.next=newNode;
            curr=curr.next;
            temp1=temp1.next;
        }
        while(temp2!=null) {
            int sum=carry;
            sum += temp2.val;
            if(sum>9) {
                sum=sum%10;
                carry=1;
            }
            else {
                carry=0;
            }
            ListNode newNode=new ListNode(sum);
            curr.next=newNode;
            curr=curr.next;
            temp2=temp2.next;
        }
        if(carry==1) {
            curr.next=new ListNode(carry);
        }
        return dummyNode.next;
    }
}