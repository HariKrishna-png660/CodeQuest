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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++) {
            set.add(nums[i]);
        }
        ListNode dummyNode=new ListNode(-1,head);
        ListNode curr=dummyNode;
        while(curr.next!=null) {
            ListNode nextNode=curr.next;
            int nodeValue=nextNode.val;
            if(set.contains(nodeValue)) {
                curr.next=nextNode.next;
            }
            else {
                curr=curr.next;
            }
        }
        return dummyNode.next;
    }
}