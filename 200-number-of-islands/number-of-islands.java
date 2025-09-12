class Solution {
    public void numIsland_dfs(int row,int col,char grid[][],boolean vis[][],int n,int m) {

        vis[row][col]=true;
        int dirs[][]={{1,0},{0,1},{-1,0},{0,-1}};
        for(int dir[]:dirs) {
            int x=dir[0]+row;
            int y=dir[1]+col;
            if(x>=0 && x<n && y>=0 && y<m && grid[x][y]=='1' && vis[x][y]==false) {
                numIsland_dfs(x,y,grid,vis,n,m);
            } 
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int islands=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]=='1' && vis[i][j]==false) {
                   numIsland_dfs(i,j,grid,vis,n,m);
                   islands++;
                }
            }
        }
        return islands;
    }
}