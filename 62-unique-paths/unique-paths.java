class Solution {
    public int uniquePaths(int sr,int sc,int dr,int dc,int dp[][]) {
        if(sr==dr && sc==dc) {
            return 1;
        }
        if(sr<0 || sc<0 || sr>dr || sc>dc) {
            return 0;
        }
        if(dp[sr][sc] != 0) {
            return dp[sr][sc];
        }
        return  dp[sr][sc]=uniquePaths(sr+1,sc,dr,dc,dp)+uniquePaths(sr,sc+1,dr,dc,dp);
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        return uniquePaths(0,0,m-1,n-1,dp);
    }
}