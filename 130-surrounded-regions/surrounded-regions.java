class Solution {
    public void explore(int row,int col,char board[][],boolean vis[][]) {
        if(row<0 ||col<0 || row>=board.length || col>=board[0].length || vis[row][col] ||board[row][col]=='X') {
            return;
        }
        vis[row][col]=true;
        board[row][col]='?';
        int dirs[][]={{-1,0},{0,-1},{1,0},{0,1}};
        for(int dir[]:dirs) {
            int x=row+dir[0];
            int y=col+dir[1];
            explore(x,y,board,vis);
        }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if((i==0||i==n-1||j==0||j==m-1) && board[i][j]=='O') {
                    explore(i,j,board,vis);
                }
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j]=='?') {
                    board[i][j]='O';
                }
                else {
                    board[i][j]='X';
                }
            }
        }
    }
}