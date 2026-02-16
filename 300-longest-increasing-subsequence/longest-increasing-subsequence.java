class Solution {
    public int lengthOfLIS(int nums[],int idx,int dp[]) {
        if(dp[idx]!=0) {
            return dp[idx];
        }
        int ans=0;
        for(int j=idx-1;j>=0;j--) {
            if(nums[j]<nums[idx]) {
                ans=Math.max(ans,lengthOfLIS(nums,j,dp));
            }
        }
        return dp[idx]=ans+1;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        int maxLen=1;
        for(int i=n-1;i>=0;i--) {
            maxLen=Math.max(maxLen,lengthOfLIS(nums,i,dp));
        }
        return maxLen;
    }
}