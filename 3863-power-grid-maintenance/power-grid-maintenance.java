class Solution {
     static class DSU {
        int[] parent;
        int[] rank;
        public DSU(int n) {
            parent = new int[n+1];
            rank = new int[n+1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return;
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
          DSU dsu = new DSU(c);
        for (int[] conn : connections) {
            dsu.union(conn[0], conn[1]);
        }

        int[] comp = new int[c+1];
        for (int i = 1; i <= c; i++) {
            comp[i] = dsu.find(i);
        }

        // Map from component root -> TreeSet of online station IDs
        Map<Integer, TreeSet<Integer>> compToSet = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            compToSet.computeIfAbsent(comp[i], k -> new TreeSet<>()).add(i);
        }

        boolean[] online = new boolean[c+1];
        Arrays.fill(online, true);

        List<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            if (type == 2) {
                if (online[x]) {
                    online[x] = false;
                    TreeSet<Integer> set = compToSet.get(comp[x]);
                    set.remove(x);
                }
            } else { // type == 1
                if (online[x]) {
                    result.add(x);
                } else {
                    TreeSet<Integer> set = compToSet.get(comp[x]);
                    if (set.isEmpty()) {
                        result.add(-1);
                    } else {
                        result.add(set.first());
                    }
                }
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }
}