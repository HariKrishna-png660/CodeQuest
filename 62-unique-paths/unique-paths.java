class Solution {
    // memoization solution ...
    public int uniquePaths(int sr,int sc,int dr,int dc,int memo[][]) {
        if(sr==dr && sc==dc) {
            return 1;
        }
        if(memo[sr][sc]!=0) {
            return memo[sr][sc];
        }
        int totalPaths=0;
        if(sr+1<=dr) {
            totalPaths += uniquePaths(sr+1,sc,dr,dc,memo);
        }
        if(sc+1<=dc) {
            totalPaths += uniquePaths(sr,sc+1,dr,dc,memo);
        }
        return memo[sr][sc]=totalPaths;
    }
    public int uniquePaths(int m, int n) {
        int memo[][]=new int[m][n];
        return uniquePaths(0,0,m-1,n-1,memo);
    }
}