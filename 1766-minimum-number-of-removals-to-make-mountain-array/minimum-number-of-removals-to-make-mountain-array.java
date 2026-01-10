class Solution {
    public int minimumMountainRemovals(int[] nums) {
        // bitonic means first increasing and then decreasing 
        // longest increasing subsequence ending at index idx
        int n=nums.length;
        int lis_dp[]=new int[n];
        int lds_dp[]=new int[n];
        // longest increasing subsequence ending at index 
        Arrays.fill(lis_dp,1);
        Arrays.fill(lds_dp,1);
        for(int i=1;i<n;i++) {
            for(int j=i-1;j>=0;j--) {
                 if(nums[j]<nums[i]) {
                    lis_dp[i]=Math.max(lis_dp[i],lis_dp[j]+1);
                 }
            }
        }
        // longest decreasing subsequence starting at index
        for(int i=n-1;i>=0;i--) {
            for(int j=i+1;j<n;j++) {
                if(nums[j]<nums[i]) {
                    lds_dp[i]=Math.max(lds_dp[i],lds_dp[j]+1);
                }
            }
        }
        int maxLen=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(lis_dp[i]==1 || lds_dp[i]==1) {
                continue;
            }
            maxLen=Math.max(maxLen,lis_dp[i]+lds_dp[i]-1);
        }
        return n-maxLen;
    }
}