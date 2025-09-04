class Solution {
    // recursive solution ... with proactive calls 
    // time complexity is O(2^(n+m))
    // space complexity is  recursive space - O(n+m)
    // public int uniquePaths(int sr,int sc,int dr,int dc) {
    //     if(sr==dr && sc==dc) {
    //         return 1;
    //     }
    //     int totalWays=0;
    //     if(sr+1<=dr) {
    //         totalWays += uniquePaths(sr+1,sc,dr,dc);
    //     }
    //     if(sc+1<=dc) {
    //         totalWays += uniquePaths(sr,sc+1,dr,dc);
    //     }
    //     return totalWays;
    // }
    // ===========================================
    // memoization solution ......
    // time complexity is O(n)
    public static int uniquePaths(int sr,int sc,int dr,int dc,int dp[][]) {
        if(sr==dr && sc==dc) {
            return dp[dr][dc]=1;
        }
        if(dp[sr][sc]!=0) {
            return dp[sr][sc];
        }
        int totalWays=0;
        if(sr+1<=dr) {
            totalWays += uniquePaths(sr+1,sc,dr,dc,dp);
        }
        if(sc+1<=dc) {
            totalWays += uniquePaths(sr,sc+1,dr,dc,dp);
        }
        return dp[sr][sc]=totalWays;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        return uniquePaths(0,0,m-1,n-1,dp);
    }
}