class Solution {
    public int[] getNextMove(int row,int col,int grid[][],int curr) {
        int n=grid.length;
        int dirs[][]={{2,-1},{2,1},{-2,-1},{-2,1},{1,2},{-1,2},{1,-2},{-1,-2}};
        for(int dir[]:dirs) {
            int x=row+dir[0];
            int y=col+dir[1];
            if(x>=0 && y>=0 && x<n && y<n && grid[x][y]==curr+1) {
                 return new int[]{x,y};
            }
        }
        return new int[]{-1,-1};
    }
    public int[] findZero(int grid[][]) {
        int n=grid.length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==0) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public boolean checkValidGrid(int[][] grid) {
          int n=grid.length;
          int count=0;
          int loc[]=findZero(grid);
          int row=loc[0];
          int col=loc[1];
          if(row != 0 || col != 0) {
              return false;
          }
          for(int i=0;i<(n*n)-1;i++) {
              int move[]=getNextMove(row,col,grid,i);
              if(move[0]==-1 && move[1] == -1) {
                  return false;
              }
              row=move[0];
              col=move[1];
          }
          return true;
    }
}