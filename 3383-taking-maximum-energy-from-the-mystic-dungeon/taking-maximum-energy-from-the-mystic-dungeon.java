class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (int j = n - 1 - i; j >= 0; j -= k) {
                sum += energy[j];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}