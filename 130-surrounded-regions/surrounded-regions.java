class Solution {
    public void solve_dfs(int row,int col,char board[][],boolean vis[][],int n,int m) {
        board[row][col]='!';
        vis[row][col]=true;
        int dirs[][]={{-1,0},{0,-1},{1,0},{0,1}};
        for(int dir[]:dirs) {
            int x=dir[0]+row;
            int y=dir[1]+col;
            if(x>=0 && x<n && y>=0 && y<m && vis[x][y]==false && board[x][y]=='O') {
                solve_dfs(x,y,board,vis,n,m);
            } 
        }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if((i==0 || i==n-1 || j==0 || j==m-1 )&& vis[i][j]==false && board[i][j]=='O') {
                   solve_dfs(i,j,board,vis,n,m);
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j]=='O') {
                    board[i][j]='X';
                }
                else if(board[i][j]=='!') {
                    board[i][j]='O';
                }
            }
        }
    }
}