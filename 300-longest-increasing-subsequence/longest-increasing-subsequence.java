class Solution {
    public int lenghtOfLIS_memo(int memo[],int idx,int nums[]) {
        if(memo[idx]!=0) {
            return memo[idx];
        }
        int ans=1;
        for(int i=idx-1;i>=0;i--) {
            if(nums[i]<nums[idx]) {
              ans=Math.max(ans,lenghtOfLIS_memo(memo,i,nums)+1);
            }
        }
        return memo[idx]=ans;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int longestIncreasingSubsequence=0;
        int memo[]=new int[n];
        for(int i=n-1;i>=0;i--) {
            longestIncreasingSubsequence=Math.max(longestIncreasingSubsequence,lenghtOfLIS_memo(memo,i,nums));
        }
        return longestIncreasingSubsequence;
    }
}