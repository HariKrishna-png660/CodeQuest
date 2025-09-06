class Solution {
    public int maxCoins_memo(int nums[],int si,int ei,int n,int dp[][]) {
        if(dp[si][ei]!=-1) {
            return dp[si][ei];
        }
        int leftVal=si==0 ? 1:nums[si-1];
        int rightVal=ei==n-1?1:nums[ei+1];

        int res=0;
        for(int cut=si;cut<=ei;cut++) {
            int left=cut==si?0:maxCoins_memo(nums,si,cut-1,n,dp);
            int right=cut==ei?0:maxCoins_memo(nums,cut+1,ei,n,dp);

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
        return maxCoins_memo(nums,0,n-1,n,dp);
    }
}