/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node detachCopyNodes(Node head) {
        Node curr=head;
        Node copyHead=curr.next;
        while(curr != null) {
            Node nextNode=curr.next.next;
            Node copy=curr.next;
            if(nextNode != null) {
                 copy.next=nextNode.next;
            }
            curr.next=nextNode;
            curr=curr.next;
        }
        return copyHead;
    }
    public void attachCopyNodesInBetween(Node head) {
        Node curr=head;
        while(curr != null) {
            Node nextNode=curr.next;
            curr.next=null;
            Node newNode=new Node(curr.val);
            curr.next=newNode;
            newNode.next=nextNode;
            curr=nextNode;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null) {
            return head;
        }
         // add new copy nodes after each and every node 
        // so after adding these newnodes the next pointer of these nodes are correctly pointed but random are pointed to null
        // copy ka random is org ka random . next 
        // after establishing these random links also 
        // then we need to detach the nodes at the odd positions from the linkedlist 
        attachCopyNodesInBetween(head);
        // list will look like this l1 l1 l2 l2 l3 l3 l4 l4 
        Node curr=head;
        int pos=0;
        Node prev=null;
        while(curr != null) {
            if(pos%2 == 0) {
               prev=curr;
            }
            else {
                if(prev.random != null) {
                    curr.random=prev.random.next;
                }
            }
            pos++;
            curr=curr.next;
        }
        return detachCopyNodes(head);
    }
}