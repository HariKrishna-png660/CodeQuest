class MedianFinder {
    PriorityQueue<Integer> minPQ;// to maintain the smallest of largest 
    PriorityQueue<Integer> maxPQ; // to maintain the largest of smallest
    public MedianFinder() {
        minPQ=new PriorityQueue<>();
        maxPQ=new PriorityQueue<>(Collections.reverseOrder());
    }
    // maxheap will have one element extra than the minheap
    public void addNum(int num) {
       if(maxPQ.size()==0) {
           maxPQ.add(num);
       }
       else if(maxPQ.peek()>=num) {
          maxPQ.add(num);
       }
       else {
          minPQ.add(num);
       }
       if(maxPQ.size()==minPQ.size()+2) {
           minPQ.add(maxPQ.remove());
       }
       else if(minPQ.size()==maxPQ.size()+1) {
           maxPQ.add(minPQ.remove());
       }
    }
    
    public double findMedian() {
         if(minPQ.size()==maxPQ.size()) {
            return (minPQ.peek()+maxPQ.peek())/2.0;
         }
         return maxPQ.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */