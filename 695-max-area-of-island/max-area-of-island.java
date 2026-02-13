class Solution {
    int par[];
    int size[];
    public int findPar(int u) {
         if(par[u]==u) {
            return u;
         }
         return par[u]=findPar(par[u]);
    }
    public int maxAreaOfIsland(int[][] grid) {
         int m=grid.length;
         int n=grid[0].length;
         par=new int[m*n];
         size=new int[m*n];
         // initialise the parent and size array
         for(int i=0;i<m;i++) { 
            for(int j=0;j<n;j++) {
              if(grid[i][j]==1) {
                 par[i*n+j]=i*n+j;
                 size[i*n+j]=1;
              }
              else {
                 par[i*n+j]=-1;
                 size[i*n+j]=0;
              }
            }
         }
         int dirs[][]={{-1,0},{0,-1},{1,0},{0,1}};
         // traverse in the grid
         for(int i=0;i<m;i++) {
             for(int j=0;j<n;j++) {
                if(grid[i][j]==1) {
                    int p1=findPar(i*n+j);
                // check the parents of the neighbours of (x,y) and then assign the parents of the neighbours as the parent of (x,y)
                for(int dir[]:dirs) {
                    int x=dir[0]+i;
                    int y=dir[1]+j;
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1) {
                        int p2=findPar(x*n+y);
                        if(p1!=p2) {
                            par[p2]=p1;
                            size[p1] += size[p2];
                        }
                    }
                }
                }
             }
         }
         int maxArea=0;
         for(int i=0;i<n*m;i++) {
            maxArea=Math.max(maxArea,size[i]);
         }
         return maxArea;
    }
}