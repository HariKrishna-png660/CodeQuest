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
    public int[] nextGreaterElement(int arr[]) {
        int n=arr.length;
        int nge[]=new int[n];
        Arrays.fill(nge,-1);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++) {
            while(st.size()>0 && arr[i]>arr[st.peek()]) {
                nge[st.pop()]=arr[i];
            }
            st.push(i);
        }
        return nge;
    }
    public ListNode removeNodes(ListNode head) {
        ArrayList<Integer> nodeValues=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null) {
            nodeValues.add(curr.val);
           curr=curr.next;
        }
        int[] arr = nodeValues.stream().mapToInt(i -> i).toArray();
        int nge[]=nextGreaterElement(arr);
        ListNode dummyNode=new ListNode(-1);
        ListNode temp=dummyNode;
        curr=head;
        int i=0;
        while(curr!=null) {
            if(nge[i]==-1) {
                 temp.next=curr;
                 temp=temp.next;
            }
            curr=curr.next;
            i++;
        }
        return dummyNode.next;
    }
}