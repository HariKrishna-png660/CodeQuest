class Solution {
    private static final int MOD = 1_000_000_007;
    public int countTrapezoids(int[][] points) {
        Map<Integer, Long> freq = new HashMap<>();
        for (int[] p : points) {
            freq.put(p[1], freq.getOrDefault(p[1], 0L) + 1);
        }
        long ans = 0;
        long sum = 0;
        for (long c : freq.values()) {
            long pairs = c * (c - 1) / 2 % MOD;
            ans = (ans + sum * pairs) % MOD;
            sum = (sum + pairs) % MOD;
        }
        return (int) ans;
    }
}
