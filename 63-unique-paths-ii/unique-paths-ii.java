class Solution {
    public int uniquePaths(int sr,int sc,int dr,int dc,int mat[][],int dp[][]) {
         if(sr==dr && sc==dc && mat[sr][sc]==0) {
            return 1;
         }
         if(dp[sr][sc] != 0) {
            return dp[sr][sc];
         }
         int paths=0;
         if(sc+1 <= dc && mat[sr][sc] == 0) {
              int rightPaths=uniquePaths(sr,sc+1,dr,dc,mat,dp);
              paths += rightPaths;
         }
         if(sr+1 <= dr && mat[sr][sc] == 0) {
              int downPaths=uniquePaths(sr+1,sc,dr,dc,mat,dp);
              paths += downPaths;
         }
         return dp[sr][sc]=paths;
    }
    public int uniquePathsWithObstacles(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int dp[][]=new int[m][n];
        // for(int i=0;i<m;i++) {
        //     Arrays.fill(dp[i],-1);
        // }
        return uniquePaths(0,0,m-1,n-1,mat,dp);
    }
}