class Solution {
    public int maxCoins(int si,int ei,int nums[],int dp[][],int n) {
        if(dp[si][ei]!=-1) {
            return dp[si][ei];
        }
        int leftVal=si==0?1:nums[si-1];
        int rightVal=ei==n-1?1:nums[ei+1];
        int res=0;
        for(int cut=si;cut<=ei;cut++) {
            int left=cut==si?0:maxCoins(si,cut-1,nums,dp,n);
            int right=cut==ei?0:maxCoins(cut+1,ei,nums,dp,n);
            int curr_ans=left+right+leftVal*nums[cut]*rightVal;
            res=Math.max(res,curr_ans);
        }
        return dp[si][ei]=res;
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n];
        for(int d[]:dp) {
            Arrays.fill(d,-1);
        }
        return maxCoins(0,n-1,nums,dp,n);
    }
}