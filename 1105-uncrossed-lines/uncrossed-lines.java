class Solution {
    public int maxuncrossedLines(int nums1[],int nums2[],int n,int m,int dp[][]) {
        if(n==0 || m==0) {
            return 0;
        }
        if(dp[n][m]!=-1) {
            return dp[n][m];
        }
        if(nums1[n-1]==nums2[m-1]) {
            return dp[n][m]=maxuncrossedLines(nums1,nums2,n-1,m-1,dp)+1;
        }
        return dp[n][m]=Math.max(maxuncrossedLines(nums1,nums2,n-1,m,dp),maxuncrossedLines(nums1,nums2,n,m-1,dp));
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++) {
            Arrays.fill(dp[i],-1);
        }
        return maxuncrossedLines(nums1,nums2,n,m,dp);
    }
}