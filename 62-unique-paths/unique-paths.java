class Solution {
    // tabulation solution ...
    public int uniquePaths(int dr,int dc,int memo[][]) {
        for(int i=dr;i>=0;i--) {
            for(int j=dc;j>=0;j--) {
                 if(i==dr && j==dc) {
                   memo[i][j]=1;
                   continue;
                 }
       
        int totalPaths=0;
        if(i+1<=dr) {
            totalPaths += memo[i+1][j];//uniquePaths(i+1,sc,dr,dc,memo);
        }
        if(j+1<=dc) {
            totalPaths += memo[i][j+1];//uniquePaths(i,sc+1,dr,dc,memo);
        }
        memo[i][j]=totalPaths; 
            }
        }
        return memo[0][0];
    }
    public int uniquePaths(int m, int n) {
        int memo[][]=new int[m][n];
        return uniquePaths(m-1,n-1,memo);
    }
}