class Solution {
    public int uniquePath_rec(int sr,int sc,int dr,int dc,int dp[][]) {
      if(sr<0 || sr>dr || sc<0 || sc>dc) {
          return 0;
      }
      if(dp[sr][sc]!=0) {
        return dp[sr][sc];
      }
      if(sr==dr && sc==dc) {
         return 1;
      }
    return dp[sr][sc]= uniquePath_rec(sr+1,sc,dr,dc,dp)+uniquePath_rec(sr,sc+1,dr,dc,dp);
}
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        return uniquePath_rec(0,0,m-1,n-1,dp);
    }
}