class Solution {
    public int minimumTeachings(int n, int[][] a, int[][] b) {
        Set<Integer> s = new HashSet<>();
        List<Set<Integer>> l = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            Set<Integer> t = new HashSet<>();
            for (int x : a[i]) t.add(x);
            l.add(t);
        }
        for (int[] x : b) {
            int p = x[0] - 1, q = x[1] - 1;
            if (Collections.disjoint(l.get(p), l.get(q))) {
                s.add(p);
                s.add(q);
            }
        }
        if (s.isEmpty()) return 0;
        int[] c = new int[n + 1];
        for (int u : s) {
            for (int x : a[u]) c[x]++;
        }
        int m = 0;
        for (int v : c) m = Math.max(m, v);
        return s.size() - m;
    }
}
