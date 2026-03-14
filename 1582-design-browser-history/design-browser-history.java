class BrowserHistory {
    ListNode curr;
    class ListNode {
        String data;
        ListNode next;
        ListNode prev;
        public ListNode(String data){
            this.data=data;
        }
    }
    public BrowserHistory(String homepage) {
        curr=new ListNode(homepage);
    }
    
    public void visit(String url) {
        ListNode newNode=new ListNode(url);
        curr.next=newNode;
        newNode.prev=curr;
        curr=newNode;
    }
    
    public String back(int steps) {
        while(curr.prev != null && steps-- > 0) {
            curr=curr.prev;
        }
        return curr.data;
    }
    
    public String forward(int steps) {
        while(curr.next != null && steps-- > 0) {
            curr=curr.next;
        }
        return curr.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */