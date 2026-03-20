class Solution {
    public int jump(int idx,int nums[],int n,int dp[]) {
         if(idx==n-1) {
            return 0;
         }
         if(dp[idx] != 0) {
            return dp[idx];
         }
         int jumps=Integer.MAX_VALUE;
         for(int i=idx+1;i<=Math.min(nums[idx]+idx,n-1);i++) {
             jumps=Math.min(jumps,jump(i,nums,n,dp));
         }
         return dp[idx]=jumps==Integer.MAX_VALUE ? jumps:jumps+1;
    }
    public int jump(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        return jump(0,nums,n,dp);
    }
}