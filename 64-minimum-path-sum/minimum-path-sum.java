class Solution {
    public int minPathSum(int sr,int sc,int dr,int dc,int grid[][],int dp[][]) {
         if(sr==dr && sc==dc) {
            return grid[dr][dc];
         }
         if(dp[sr][sc] != -1) {
             return dp[sr][sc];
         }
         int minSum=Integer.MAX_VALUE;
        //  currSum += grid[sr][sc];
         if(sr+1 <= dr ) {
             minSum=Math.min(minSum,minPathSum(sr+1,sc,dr,dc,grid,dp));
         }
         if(sc+1 <= dc) {
             minSum=Math.min(minSum,minPathSum(sr,sc+1,dr,dc,grid,dp));
         }
        //  minSum
         return dp[sr][sc]=minSum+grid[sr][sc];
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++) {
            Arrays.fill(dp[i],-1);
        }
        return  minPathSum(0,0,m-1,n-1,grid,dp);
    }
}