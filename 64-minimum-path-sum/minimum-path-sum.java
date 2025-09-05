class Solution {
    // // memoization 
    // public int minPathSum(int sr,int sc,int dr,int dc,int grid[][],int dp[][]) {
    //     if(sr==dr && sc==dc) {
    //         return dp[dr][dc]=grid[dr][dc];
    //     }
    //     if(dp[sr][sc]!=-1) {
    //         return dp[sr][sc];
    //     }
    //     int minSum=Integer.MAX_VALUE;
    //     if(sr+1<=dr) {
    //         minSum=minPathSum(sr+1,sc,dr,dc,grid,dp);
    //     }
    //     if(sc+1<=dc) {
    //         minSum=Math.min(minSum,minPathSum(sr,sc+1,dr,dc,grid,dp));
    //     }
    //     return dp[sr][sc]=minSum+grid[sr][sc];
    // }
    // tabulation solution ....
    public int minPathSum(int dr,int dc,int grid[][],int dp[][]) {
        //  for(int j=dc;j>=0;j--) {
        // for(int i=dr;i>=0;i--) {
        //         if(i==dr && j==dc) {
        //             tab[dr][dc]=grid[dr][dc];
        //             continue;
        //         }
        //         int minSum=Integer.MAX_VALUE;
        //         if(i+1<=dr) {
        //             minSum=Math.min(minSum,tab[i+1][j]);
        //         }
        //         if(j+1<=dc) {
        //            minSum=Math.min(minSum,tab[i][j+1]);
        //         }
        //         minSum += grid[i][j];
        //         tab[i][j]=minSum;
        //     }
        // }
        // return tab[0][0];
        for(int i=dr;i>=0;i--) {
            for(int j=dc;j>=0;j--) {
               if(i==dr && j==dc) {
                   dp[dr][dc]=grid[dr][dc];
                   continue;
               }
               int minSum=Integer.MAX_VALUE;
               if(i+1<=dr) {
                  minSum=Math.min(minSum,dp[i+1][j]);
               }
               if(j+1<=dc) {
                  minSum=Math.min(minSum,dp[i][j+1]);
               }
               minSum += grid[i][j];
               dp[i][j]=minSum;
            }
        }

        return dp[0][0];
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        // for(int i=0;i<m;i++) {
        //     Arrays.fill(dp[i],-1);
        // }
        // return minPathSum(0,0,m-1,n-1,grid,dp);
        return minPathSum(m-1,n-1,grid,dp);
    }
}