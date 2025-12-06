class Solution {
    public int countPartitions(int[] nums, int k) {
        int MOD = 1_000_000_007;
        int n = nums.length;
        Deque<Integer> dqMin = new ArrayDeque<>();
        Deque<Integer> dqMax = new ArrayDeque<>();
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];
        dp[0] = 1;
        prefix[0] = 1;
        int left = 0;
        for (int right = 0; right < n; right++) {
            while (!dqMin.isEmpty() && nums[dqMin.peekLast()] >= nums[right]) dqMin.pollLast();
            dqMin.offerLast(right);
            while (!dqMax.isEmpty() && nums[dqMax.peekLast()] <= nums[right]) dqMax.pollLast();
            dqMax.offerLast(right);
            while (!dqMin.isEmpty() && !dqMax.isEmpty() && nums[dqMax.peekFirst()] - nums[dqMin.peekFirst()] > k) {
                if (dqMin.peekFirst() == left) dqMin.pollFirst();
                if (dqMax.peekFirst() == left) dqMax.pollFirst();
                left++;
            }
            // now window [left..right] is valid
            dp[right + 1] = (prefix[right] - (left > 0 ? prefix[left - 1] : 0) + MOD) % MOD;
            prefix[right + 1] = (prefix[right] + dp[right + 1]) % MOD;
        }
        return (int) dp[n];
    }
}
