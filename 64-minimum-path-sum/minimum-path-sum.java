class Solution {
    // tabulation solution ....
    public int minPathSum(int dr,int dc,int grid[][],int tab[][]) {
         for(int j=dc;j>=0;j--) {
        for(int i=dr;i>=0;i--) {
                if(i==dr && j==dc) {
                    tab[dr][dc]=grid[dr][dc];
                    continue;
                }
                int minSum=Integer.MAX_VALUE;
                if(i+1<=dr) {
                    minSum=Math.min(minSum,tab[i+1][j]);
                }
                if(j+1<=dc) {
                   minSum=Math.min(minSum,tab[i][j+1]);
                }
                minSum += grid[i][j];
                tab[i][j]=minSum;
            }
        }
        return tab[0][0];
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int tab[][]=new int[m][n];
        return minPathSum(m-1,n-1,grid,tab);
    }
}