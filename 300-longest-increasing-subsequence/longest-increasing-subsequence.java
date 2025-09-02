class Solution {
    // memoization solution ......
    // public int lengthOfLIS_rec(int nums[],int idx,int memo[]) {
    //     if(memo[idx]!=1) {
    //         return memo[idx];
    //     }
    //     int ans=1;
    //     for(int j=idx-1;j>=0;j--) {
    //         if(nums[j]<nums[idx]) {
    //             ans=Math.max(ans,lengthOfLIS_rec(nums,j,memo)+1);
    //         }
    //     }
    //     return memo[idx]=ans;
    // }
    // tabulation solution ....
    public int lengthOfLIS_tab(int nums[]) {
        int n=nums.length;
        int tab[]=new int[n];
        Arrays.fill(tab,1);
        int res=0;
        for(int idx=0;idx<n;idx++) {
            int ans=1;
            for(int j=idx-1;j>=0;j--) {
                if(nums[j]<nums[idx]) {
                    ans=Math.max(ans,tab[j]+1);
                }
            }
            tab[idx]=ans;
            res=Math.max(res,ans);
        }
        return res;
    }
    public int lengthOfLIS(int[] nums) {
        // int n=nums.length;
        // int memo[]=new int[n];
        // Arrays.fill(memo,1);
        // int ans=0;
        // for(int i=n-1;i>=0;i--) {
        //     ans=Math.max(ans,lengthOfLIS_rec(nums,i,memo));
        // }
        // return ans;
        int n=nums.length;
        return lengthOfLIS_tab(nums);
    }
}