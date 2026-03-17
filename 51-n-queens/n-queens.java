class Solution {
    public void addCurrentBoard(List<List<String>> ans,boolean vis[][]) {
        List<String> list=new ArrayList<>();
        int n=vis.length;
        for(int i=0;i<n;i++) {
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++) {
                if(vis[i][j]) {
                    sb.append('Q');
                }
                else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        ans.add(list);
    }
    public boolean isPossibleToPlaceHere(int row,int col,boolean vis[][]) {
        // you should check for only those cells (row-1,col-1) (row-1,col) (row-1,col+1)
        int n=vis.length;
        int dirs[][]={{-1,-1},{-1,0},{-1,1}};
        for(int rad=1;rad<n;rad++) {
             for(int dir[]:dirs) {
                int x=row+rad*dir[0];
                int y=col+rad*dir[1];
                if(x>=0 && y>=0 && x<n && y<n) {
                    if(vis[x][y]==true) {
                        return false;
                    }
                }
             }
        }
        // vis[row][col]=true;
        return true;
    }
    public void Nqueens(int row,int n,boolean vis[][],List<List<String>> ans) {
         if(row==n) {
             addCurrentBoard(ans,vis);
             return;
         }
         for(int col=0;col<n;col++) {
             if(isPossibleToPlaceHere(row,col,vis)) {
                  vis[row][col]=true;
                  Nqueens(row+1,n,vis,ans);
                  vis[row][col]=false;
            }
         }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        boolean vis[][]=new boolean[n][n];
        Nqueens(0,n,vis,ans);
        return ans;
    }
}