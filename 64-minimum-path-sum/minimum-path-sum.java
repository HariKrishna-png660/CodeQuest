class Solution {
    // memoization solution ......
    public int minPathSum(int sr,int sc,int dr,int dc,int memo[][],int grid[][]) {
        if(sr==dr && sc==dc) {
            return grid[dr][dc];
        }
        if(memo[sr][sc]!=-1) {
            return memo[sr][sc];
        }
        int minSum=Integer.MAX_VALUE;
        if(sr+1<=dr) {
            minSum=Math.min(minSum,minPathSum(sr+1,sc,dr,dc,memo,grid));
        }
        if(sc+1<=dc) {
            minSum=Math.min(minSum,minPathSum(sr,sc+1,dr,dc,memo,grid));
        }
        return memo[sr][sc]=minSum+grid[sr][sc];
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int memo[][]=new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                memo[i][j]=-1;
            }
        }
        return minPathSum(0,0,m-1,n-1,memo,grid);
    }
}