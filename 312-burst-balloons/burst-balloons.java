class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n];
        for(int gap=0;gap<n;gap++) {
            for(int si=0,ei=gap;ei<n;si++,ei++) {
                int leftVal=si==0?1:nums[si-1];
                int rightVal=ei==n-1?1:nums[ei+1];

                int res=0;
                for(int cut=si;cut<=ei;cut++) {
                    int left=cut==si?0:dp[si][cut-1];
                    int right=cut==ei?0:dp[cut+1][ei];
                    int curr_ans=left+right+leftVal*rightVal*nums[cut];
                    res=Math.max(res,curr_ans);
                }
                dp[si][ei]=res;
            }
        }
        return dp[0][n-1];
    }
}