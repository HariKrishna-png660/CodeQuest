class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        // intilaise the max heap
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        // iterate through the entire array and add every element into the heap
        for(int i=0;i<n;i++) {
            int value=nums[i];
            minHeap.add(value);
            // make sure that the size of the minHeap doesn't exceed k
            if(minHeap.size()>k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}