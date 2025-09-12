class Solution {
    public int maxAreaIsland_dfs(int row,int col,int grid[][],boolean vis[][],int n,int m) {
        int ans=1;
        vis[row][col]=true;
        int dirs[][]={{-1,0},{0,-1},{1,0},{0,1}};
        for(int dir[]:dirs) {
            int x=dir[0]+row;
            int y=dir[1]+col;
            if(x>=0 && x<n && y>=0 && y<m && grid[x][y]==1 && vis[x][y]==false) {
                 ans += maxAreaIsland_dfs(x,y,grid,vis,n,m);
            }
        }
        return ans;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];

        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1 && vis[i][j]==false) {
                    int area=maxAreaIsland_dfs(i,j,grid,vis,n,m);
                    maxArea=Math.max(maxArea,area);
                }
            }
        }
        if(maxArea==Integer.MIN_VALUE) {
            return 0;
        }
        return maxArea;
    }
}