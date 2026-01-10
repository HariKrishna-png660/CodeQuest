class Solution {
    public int cherryPickUp_rec(int row,int col1,int col2,int grid[][],int dp[][][],int n,int m) {
        int cherries=0;
        if(col1 == col2) {
            cherries=grid[row][col1];
        }
        else {
            cherries=grid[row][col1]+grid[row][col2];
        }
        if(row==n-1) {
            return cherries;
        }
        if(dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }
        int maxAns=0;
        for(int nextR1Pos=col1-1;nextR1Pos<=col1+1;nextR1Pos++) {
            for(int nextR2Pos=col2-1;nextR2Pos<=col2+1;nextR2Pos++) {
                if(nextR1Pos >=0 && nextR1Pos < m && nextR2Pos >=0 && nextR2Pos<m) {
                    maxAns=Math.max(maxAns,cherryPickUp_rec(row+1,nextR1Pos,nextR2Pos,grid,dp,n,m));
                }
            }
        }
        return dp[row][col1][col2]=cherries+maxAns;
    }
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][][]=new int[n][m][m];
        for(int d[][]:dp) {
            for(int a[]:d) {
                Arrays.fill(a,-1);
            }
        }
        return cherryPickUp_rec(0,0,m-1,grid,dp,n,m);
    }
}