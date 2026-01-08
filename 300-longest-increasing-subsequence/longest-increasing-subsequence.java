class Solution {
    public int lengthOfLIS(int idx,int dp[],int nums[]) {
         if(dp[idx]!=0) {
            return dp[idx];
         }
         int ans=0;
         for(int j=idx-1;j>=0;j--) {
               if(nums[j]<nums[idx]) {
                  ans=Math.max(ans,lengthOfLIS(j,dp,nums));
               }
         }
         return dp[idx]=ans+1;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        int res=0;
        for(int i=0;i<n;i++) {
            res=Math.max(res,lengthOfLIS(i,dp,nums));
        }
        return res;
    }
}