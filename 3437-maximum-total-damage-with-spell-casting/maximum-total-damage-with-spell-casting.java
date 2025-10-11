class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int p : power) map.put(p, map.getOrDefault(p, 0) + 1);
        List<Integer> vals = new ArrayList<>(map.keySet());
        Collections.sort(vals);
        int n = vals.size();
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            int j = upperBound(vals, vals.get(i) + 2, i + 1);
            next[i] = j;
        }
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            long skip = dp[i + 1];
            long take = (long) vals.get(i) * map.get(vals.get(i)) + (next[i] < n ? dp[next[i]] : 0);
            dp[i] = Math.max(skip, take);
        }
        return dp[0];
    }

    private int upperBound(List<Integer> list, int target, int start) {
        int l = start, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) <= target) l = m + 1;
            else r = m;
        }
        return l;
    }
}
