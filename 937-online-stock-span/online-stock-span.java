class StockSpanner {
    class Pair {
        int index;
        int value;
        public Pair(int index,int value) {
            this.index=index;
            this.value=value;
        }
    }
    Stack<Pair> st;
    int ind;
    public StockSpanner() {
        st=new Stack<>();
        st.push(new Pair(-1,-1));
        ind=0;
    }
    
    public int next(int price) {
        while(st.peek().value!=-1 && st.peek().value<=price) {
            st.pop();
        }
        int span=ind-st.peek().index;
        st.push(new Pair(ind++,price));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */