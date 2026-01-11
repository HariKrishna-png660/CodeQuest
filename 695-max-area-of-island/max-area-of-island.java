class Solution {
    public int areaOfIsland(int grid[][],boolean vis[][],int row,int col) {
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==0 || vis[row][col]) {
            return 0;
        }
        vis[row][col]=true;
        int dirs[][]={{-1,0},{0,-1},{1,0},{0,1}};
        int area=0;
        for(int dir[]:dirs) {
            int x=row+dir[0];
            int y=col+dir[1];
            area += areaOfIsland(grid,vis,x,y);
        }
        return area+1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int maxArea=Integer.MIN_VALUE;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1 && !vis[i][j]) {
                     maxArea=Math.max(maxArea,areaOfIsland(grid,vis,i,j));
                }
            }
        }
        return maxArea==Integer.MIN_VALUE ? 0:maxArea;
    }
}