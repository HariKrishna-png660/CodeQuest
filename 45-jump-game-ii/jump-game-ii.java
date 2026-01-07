class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--) {
            int min=Integer.MAX_VALUE;
            for(int j=0;j<nums[i];j++) {
                if(i+j+1<n) {
                   min=Math.min(min,dp[i+j+1]);
                }
            }
            if(min!=Integer.MAX_VALUE) {
                dp[i]=min+1;
            }
            else {
                dp[i]=min;
            }
        }
        return dp[0];
    }
}