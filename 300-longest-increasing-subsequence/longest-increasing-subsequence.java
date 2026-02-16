class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        int maxLen=1;
        for(int i=0;i<n;i++) {
            if(i==0) {
                dp[i]=1;
                continue;
            }
            int ans=0;
            for(int j=i-1;j>=0;j--) {
                if(nums[j]<nums[i]) {
                    ans=Math.max(ans,dp[j]);
                }
            }
            dp[i]=ans+1;
            maxLen=Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}