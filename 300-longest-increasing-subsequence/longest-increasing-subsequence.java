class Solution {
    // memoization solution .......
    // public int lenghtOfLIS_memo(int memo[],int idx,int nums[]) {
    //     if(memo[idx]!=0) {
    //         return memo[idx];
    //     }
    //     int ans=1;
    //     for(int i=idx-1;i>=0;i--) {
    //         if(nums[i]<nums[idx]) {
    //           ans=Math.max(ans,lenghtOfLIS_memo(memo,i,nums)+1);
    //         }
    //     }
    //     return memo[idx]=ans;
    // }
    public int lengthOfLIS(int[] nums) {
        // int n=nums.length;
        // int longestIncreasingSubsequence=0;
        // int memo[]=new int[n];
        // for(int i=n-1;i>=0;i--) {
        //     longestIncreasingSubsequence=Math.max(longestIncreasingSubsequence,lenghtOfLIS_memo(memo,i,nums));
        // }
        // return longestIncreasingSubsequence;
        // tabulation solution .......
        int n=nums.length;
        int tab[]=new int[n];
        Arrays.fill(tab,1);
        int maxLIS=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i]) {
                    tab[i]=Math.max(tab[i],tab[j]+1);
                }
            }
            maxLIS=Math.max(maxLIS,tab[i]);
        }
        return maxLIS;
    }
}