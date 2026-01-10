class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int count[]=new int[n];
        int dp[]=new int[n];
        Arrays.fill(count,1);
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++) {
            for(int j=i-1;j>=0;j--) {
                if(nums[j]<nums[i]) {
                     if(dp[i]<dp[j]+1) {
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                     }
                     else if(dp[i]==dp[j]+1) {
                        count[i] += count[j];
                     }
                }
            }
        }
        int maxLen=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            maxLen=Math.max(maxLen,dp[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++) {
            if(dp[i]==maxLen) {
                ans += count[i];
            }
        }
        return ans;
    }
}