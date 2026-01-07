class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int j=n-1;j>=0;j--) {
            for(int i=m-1;i>=0;i--) {
                if(i==m-1 && j==n-1) {
                    dp[i][j]=grid[i][j];
                    continue;
                }
                dp[i][j]=grid[i][j];
                int min=Integer.MAX_VALUE;
                if(i+1<m) {
                   min=Math.min(min,dp[i+1][j]);
                }
                if(j+1<n) {
                   min=Math.min(min,dp[i][j+1]); 
                }
                dp[i][j] += min;
            }
        }
        return dp[0][0];
    }
}