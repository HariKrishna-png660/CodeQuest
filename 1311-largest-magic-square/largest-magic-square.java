class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] row = new int[n][m + 1];
        int[][] col = new int[n + 1][m];
        int[][] d1 = new int[n + 1][m + 1];
        int[][] d2 = new int[n + 1][m + 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
                d1[i + 1][j + 1] = d1[i][j] + grid[i][j];
                d2[i + 1][j] = d2[i][j + 1] + grid[i][j];
            }
        }
        
        int ans = 1;
        for (int k = 2; k <= Math.min(n, m); k++) {
            for (int i = 0; i + k - 1 < n; i++) {
                for (int j = 0; j + k - 1 < m; j++) {
                    int x1 = i, y1 = j;
                    int x2 = i + k - 1, y2 = j + k - 1;
                    
                    int target = d1[x2 + 1][y2 + 1] - d1[x1][y1];
                    if (target != d2[x2 + 1][y1] - d2[x1][y2 + 1]) continue;
                    
                    boolean ok = true;
                    for (int r = x1; r <= x2 && ok; r++) {
                        if (row[r][y2 + 1] - row[r][y1] != target) ok = false;
                    }
                    for (int c = y1; c <= y2 && ok; c++) {
                        if (col[x2 + 1][c] - col[x1][c] != target) ok = false;
                    }
                    
                    if (ok) ans = k;
                }
            }
        }
        return ans;
    }
}
