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
    public Node detachInBetweenList(Node head) {
        Node copyHead=head.next;
        Node curr=head;
        while(curr!=null) {
            Node nextNode=curr.next.next;
            Node copy=curr.next;
            if(nextNode!=null) {
                copy.next=nextNode.next;
            }
            curr.next=nextNode;
            curr=curr.next;
        }
        return copyHead;
    }
    public void attachCopyNodesInBetween(Node head) {
        Node curr=head;
        while(curr!=null) {
            Node nextNode=curr.next;
            curr.next=null;
            Node copy=new Node(curr.val);
            copy.next=nextNode;
            curr.next=copy;
            curr=nextNode;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null) {
            return head;
        }
        attachCopyNodesInBetween(head);
        Node curr=head;
        while(curr!=null) {
            Node nextNode=curr.next.next;
            Node copy=curr.next;
            if(curr.random != null) {
                copy.random=curr.random.next;
            }
            curr=nextNode;
        }
        return detachInBetweenList(head);
    }
}