class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][]=new int[m][n];
        for(int j=n-1;j>=0;j--) {
            for(int i=m-1;i>=0;i--) {
                 if(obstacleGrid[i][j]==1) {
                     continue;
                 }
                 if(i==m-1 && j==n-1) {
                    dp[i][j]=1;
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