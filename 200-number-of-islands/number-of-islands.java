class Solution {
    public void exploreIsland(char grid[][],int row,int col,boolean vis[][]) {
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]=='0' || vis[row][col]) {
           return;
        }
        vis[row][col]=true;
        int dirs[][]={{-1,0},{0,-1},{1,0},{0,1}};
        for(int dir[]:dirs) {
            int x=row+dir[0];
            int y=col+dir[1];
            exploreIsland(grid,x,y,vis);
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int numberOfIslands=0;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                char ch=grid[i][j];
                if(ch=='1' && !vis[i][j]) {
                    exploreIsland(grid,i,j,vis);
                    numberOfIslands++;
                }
            }
        }
       return numberOfIslands;
    }
}