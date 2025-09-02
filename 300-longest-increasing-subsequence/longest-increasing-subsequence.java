class Solution {
    public int lengthOfLIS_rec(int nums[],int idx,int memo[]) {
        if(memo[idx]!=1) {
            return memo[idx];
        }
        int ans=1;
        for(int j=idx-1;j>=0;j--) {
            if(nums[j]<nums[idx]) {
                ans=Math.max(ans,lengthOfLIS_rec(nums,j,memo)+1);
            }
        }
        return memo[idx]=ans;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int memo[]=new int[n];
        Arrays.fill(memo,1);
        int ans=0;
        for(int i=n-1;i>=0;i--) {
            ans=Math.max(ans,lengthOfLIS_rec(nums,i,memo));
        }
        return ans;
    }
}