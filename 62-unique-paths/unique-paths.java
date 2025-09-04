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
    // time complexity is O(mxn) .. (time for filling the 2d array of size mxn)
    // space complexity is O(mxn) .. (recursive stack space O(n+m) + 2d array O(mxn) ===== O(mxn))
    // public static int uniquePaths(int sr,int sc,int dr,int dc,int dp[][]) {
    //     if(sr==dr && sc==dc) {
    //         return dp[dr][dc]=1;
    //     }
    //     if(dp[sr][sc]!=0) {
    //         return dp[sr][sc];
    //     }
    //     int totalWays=0;
    //     if(sr+1<=dr) {
    //         totalWays += uniquePaths(sr+1,sc,dr,dc,dp);
    //     }
    //     if(sc+1<=dc) {
    //         totalWays += uniquePaths(sr,sc+1,dr,dc,dp);
    //     }
    //     return dp[sr][sc]=totalWays;
    // }
    // ===========================================
    // tabulation solution .....
    // time complexity - O(nXm)
    // space complexity -O(nxm)
    // public static int uniquePaths(int dp[][],int m,int n) {
    //     // for(int j=n-1;j>=0;j--) {
    //     //     for(int i=m-1;i>=0;i--) {
    //     //         if(i==m-1 && j==n-1) {
    //     //              dp[i][j]=1;
    //     //              continue;
    //     //         }
    //     //         int totalWays=0;
    //     //         if(i+1<m) {
    //     //             totalWays += dp[i+1][j];
    //     //         }
    //     //         if(j+1<n) {
    //     //             totalWays += dp[i][j+1];
    //     //         }
    //     //         dp[i][j]=totalWays;
    //     //     }
    //     // }
    //     // return dp[0][0];

    //     for(int i=m-1;i>=0;i--) {
    //         for(int j=n-1;j>=0;j--) {
    //             if(i==m-1 && j==n-1) {
    //                 dp[i][j]=1;
    //                 continue;
    //             }
    //             int totalWays=0;
    //             if(i+1<m) {
    //                 totalWays += dp[i+1][j];
    //             }
    //             if(j+1<n) {
    //                 totalWays += dp[i][j+1];
    //             }
    //             dp[i][j]=totalWays;
    //         }
    //     }
    //     return dp[0][0];
    // }
    // =======================================
    // tabulation with space optimisation ...... 
    // time complexity - O(nXm)
    // space complexity -O(n) (using two arrays)
    // public int uniquePaths_opt(int m,int n) {
    //     // int dp[]=new int[m];
    //     // dp[m-1]=1;
    //     // for(int j=n-1;j>=0;j--) {
    //     //     int newCol[]=new int[m];
    //     //     for(int i=m-1;i>=0;i--) {
    //     //         if(i==m-1 && j==n-1) {
    //     //             newCol[i]=1;
    //     //         }
    //     //         else {
    //     //             int totalWays=0;
    //     //             if(i+1<m) {
    //     //                 totalWays += newCol[i+1];
    //     //             }
    //     //             if(j+1<n) {
    //     //                 totalWays += dp[i];
    //     //             }
    //     //             newCol[i]=totalWays;
    //     //         }
    //     //     }
    //     //     dp=newCol;
    //     // }
    //     // return dp[0];
        
    //     int dp[]=new int[n];
    //     dp[n-1]=1;
    //     for(int i=m-1;i>=0;i--) {
    //         int newRow[]=new int[n];
    //         for(int j=n-1;j>=0;j--) {
    //             if(i==m-1 && j==n-1) {
    //                 newRow[j]=1;
    //                 continue;
    //             }
    //             int totalWays=0;
    //             if(i+1<m) {
    //                 totalWays += dp[j];
    //             }
    //             if(j+1<n) {
    //                 totalWays += newRow[j+1];
    //             }
    //            newRow[j]=totalWays;
    //         }
    //         dp=newRow;
    //     }
    //    return dp[0];
    // }
    // ===============================================
    // using one array
    public int uniquePaths_opt(int m,int n) {
        int dp[]=new int[n];
        dp[n-1]=1;
        for(int i=m-1;i>=0;i--) {
            for(int j=n-2;j>=0;j--) {
                dp[j]=dp[j]+dp[j+1];
            }
        }
        return dp[0];
    }
    public int uniquePaths(int m, int n) {
        // int dp[][]=new int[m][n];
        // return uniquePaths(0,0,m-1,n-1,dp);
        // int dp[][]=new int[m][n];
        // return uniquePaths(dp,m,n);
        return uniquePaths_opt(m,n);
    }
}