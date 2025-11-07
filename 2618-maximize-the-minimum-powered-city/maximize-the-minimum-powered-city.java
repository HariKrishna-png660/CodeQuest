class Solution {
    public long maxPower(int[] stations, int r, long k) {
        int n = stations.length;
        long[] prefix = new long[n];
        prefix[0] = stations[0];
        for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + stations[i];
        long[] power = new long[n];
        for (int i = 0; i < n; i++) {
            int L = Math.max(0, i - r);
            int R = Math.min(n - 1, i + r);
            power[i] = prefix[R] - (L > 0 ? prefix[L - 1] : 0);
        }
        long left = 0, right = (long)1e18, ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canAchieve(power, r, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }

    boolean canAchieve(long[] power, int r, long k, long target) {
        int n = power.length;
        long[] diff = new long[n + 1];
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur += diff[i];
            long have = power[i] + cur;
            if (have < target) {
                long need = target - have;
                if (need > k) return false;
                k -= need;
                cur += need;
                int end = i + 2 * r + 1;
                if (end < n) diff[end] -= need;
            }
        }
        return true;
    }
}
