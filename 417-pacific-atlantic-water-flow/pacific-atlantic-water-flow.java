class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);
            dfs(heights, atlantic, i, m - 1, heights[i][m - 1]);
        }
        for (int j = 0; j < m; j++) {
            dfs(heights, pacific, 0, j, heights[0][j]);
            dfs(heights, atlantic, n - 1, j, heights[n - 1][j]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    void dfs(int[][] h, boolean[][] vis, int i, int j, int prev) {
        int n = h.length, m = h[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || h[i][j] < prev) return;
        vis[i][j] = true;
        dfs(h, vis, i + 1, j, h[i][j]);
        dfs(h, vis, i - 1, j, h[i][j]);
        dfs(h, vis, i, j + 1, h[i][j]);
        dfs(h, vis, i, j - 1, h[i][j]);
    }
}
