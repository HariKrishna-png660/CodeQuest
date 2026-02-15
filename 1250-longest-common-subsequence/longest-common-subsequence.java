class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
         int n=text1.length();
         int m=text2.length();
         int dp[][]=new int[n+1][m+1];
         for(int j=0;j<=m;j++) {
            for(int i=0;i<=n;i++) {
                if(i==0 || j==0) {
                    continue;
                }
                if(text1.charAt(i-1)==text2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
         }
         return dp[n][m];
    }
}