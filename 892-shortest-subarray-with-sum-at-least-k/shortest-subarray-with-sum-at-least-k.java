class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        long[] pre=new long[n];
        pre[0]=nums[0];

        for(int i=1;i<n;i++) {
            pre[i]=pre[i-1]+nums[i];
        }
        LinkedList<Integer> deque=new LinkedList<>();
        int ans=Integer.MAX_VALUE;

        for(int i=0;i<n;i++) {
            if(pre[i]>=k) {
                ans=Math.min(i+1,ans);
            }

            while(deque.size()>0 && pre[i]-pre[deque.getFirst()]>=k) {
                ans=Math.min(ans,i-deque.getFirst());
                deque.removeFirst();
            }
            while(deque.size()>0 && pre[i]<=pre[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
       return ans == Integer.MAX_VALUE ? -1:ans;
    }
}