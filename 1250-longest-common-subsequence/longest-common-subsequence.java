class Solution {
    public int lcs_rec(int n,int m,String s1,String s2,int dp[][]) {
        if(n==0 || m==0) {
            return dp[n][m]=0;
        }
        if(dp[n][m]!=-1) {
            return dp[n][m];
        }
        int ans=0;
        if(s1.charAt(n-1)==s2.charAt(m-1)) {
            ans=lcs_rec(n-1,m-1,s1,s2,dp)+1;
        }
        else {
            ans=Math.max(lcs_rec(n,m-1,s1,s2,dp),lcs_rec(n-1,m,s1,s2,dp));
        }
        return dp[n][m]=ans;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int dp[][]=new int[n+1][m+1];
        for(int d[]:dp) {
            Arrays.fill(d,-1);
        }
        return lcs_rec(n,m,text1,text2,dp);
    }
}