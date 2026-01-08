class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int j=0;j<=m;j++) {
            for(int i=0;i<=n;i++) {
                if(i<j) {
                    continue;
                }
                if(j==0) {
                    dp[i][j]=1;
                    continue;
                }
                dp[i][j]=dp[i-1][j];
                if(s.charAt(i-1)==t.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[n][m];
    }
}