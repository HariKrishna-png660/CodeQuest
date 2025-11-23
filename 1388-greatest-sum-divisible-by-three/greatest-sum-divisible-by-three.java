class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for (int num : nums) {
            int[] tmp = dp.clone();
            for (int v : tmp) {
                dp[(v + num) % 3] = Math.max(dp[(v + num) % 3], v + num);
            }
        }
        return dp[0];
    }
}