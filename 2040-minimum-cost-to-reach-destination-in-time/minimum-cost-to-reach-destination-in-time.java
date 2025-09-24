class Solution {
    class Edge {
        int u, v, w;
        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    class Pair {
        int vtx, time, cost;
        public Pair(int vtx, int time, int cost) {
            this.vtx = vtx;
            this.time = time;
            this.cost = cost;
        }
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int N = passingFees.length;  
        ArrayList<Edge>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w));
        }

        int[][] dis = new int[N][maxTime + 1];
        for (int[] row : dis) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Pair(0, 0, passingFees[0]));
        dis[0][0] = passingFees[0];

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (cur.vtx == N - 1) return cur.cost; 

            for (Edge e : graph[cur.vtx]) {
                int nt = cur.time + e.w;
                if (nt > maxTime) continue;
                int nc = cur.cost + passingFees[e.v];
                if (nc < dis[e.v][nt]) {
                    dis[e.v][nt] = nc;
                    pq.add(new Pair(e.v, nt, nc));
                }
            }
        }
        return -1;
    }
}
