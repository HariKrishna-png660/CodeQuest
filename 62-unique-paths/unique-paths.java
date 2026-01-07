class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        
        for(int j=n-1;j>=0;j--) {
            for(int i=m-1;i>=0;i--) {
                if(i==m-1 && j==n-1) {
                    dp[m-1][n-1]=1;
                    continue;
                }
                dp[i][j]=0;
                if(i+1<m) {
                    dp[i][j] += dp[i+1][j];
                }
                if(j+1<n) {
                    dp[i][j] += dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}