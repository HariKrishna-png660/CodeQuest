class Solution {
    // recursive solution ..... will get tle ...
    // public int uniquePathsWithObstacles(int sr,int sc,int dr,int dc,int obstacleGrid[][]) {
    //     if(obstacleGrid[sr][sc]==1) {
    //         return 0;
    //     }
    //     if(sr==dr && sc==dc) {
    //         return 1;
    //     }
    //     int totalWays=0;
    //     if(sr+1<=dr && obstacleGrid[sr+1][sc]==0) {
    //         totalWays += uniquePathsWithObstacles(sr+1,sc,dr,dc,obstacleGrid);
    //     }
    //     if(sc+1<=dc && obstacleGrid[sr][sc+1]==0) {
    //         totalWays += uniquePathsWithObstacles(sr,sc+1,dr,dc,obstacleGrid);
    //     }
    //     return totalWays;
    // }
    // memoization solution ....
    public static int uniquePathsWithObstacles(int sr,int sc,int dr,int dc,int obstacleGrid[][],int memo[][]) {
         if(obstacleGrid[sr][sc]==1) {
            return 0;
         }
         if(sr==dr && sc==dc) {
            return 1;
         }
          if(memo[sr][sc]!=-1) {
             return memo[sr][sc];
          }
          int totalPaths=0;
          if(sr+1<=dr && obstacleGrid[sr+1][sc]==0) {
             totalPaths += uniquePathsWithObstacles(sr+1,sc,dr,dc,obstacleGrid,memo);
          }
          if(sc+1<=dc && obstacleGrid[sr][sc+1]==0) {
             totalPaths += uniquePathsWithObstacles(sr,sc+1,dr,dc,obstacleGrid,memo);
          }
          return memo[sr][sc]=totalPaths;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        // return uniquePathsWithObstacles(0,0,m-1,n-1,obstacleGrid);
        int memo[][]=new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                memo[i][j]=-1;
            }
        }
        return uniquePathsWithObstacles(0,0,m-1,n-1,obstacleGrid,memo);
    }
}