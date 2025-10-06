class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]}); // row, col, time
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int ans = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], t = curr[2];
            ans = Math.max(ans, t);

            if (r == n - 1 && c == n - 1) return ans;
            if (visited[r][c]) continue;
            visited[r][c] = true;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]) {
                    pq.offer(new int[]{nr, nc, grid[nr][nc]});
                }
            }
        }
        return ans;
    }
}
