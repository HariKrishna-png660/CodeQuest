class BrowserHistory {
    class ListNode {
        String data;
        ListNode next;
        ListNode prev;
        public ListNode(String data) {
            this.data=data;
        }
    }
    ListNode currNode;
    public BrowserHistory(String homepage) {
        currNode=new ListNode(homepage);
    }
    
    public void visit(String url) {
        ListNode newNode=new ListNode(url);
        currNode.next=newNode;
        newNode.prev=currNode;
        currNode=newNode;
    }
    
    public String back(int steps) {
        while(currNode.prev!=null && steps-->0) {
            currNode=currNode.prev;
        }
        return currNode.data;
    }
    
    public String forward(int steps) {
        while(currNode.next!=null && steps-->0) {
            currNode=currNode.next;
        }
        return currNode.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */