public class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer,Integer> cnt = new HashMap<>();
        TreeMap<Integer,Integer> diff = new TreeMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num,0)+1);
            diff.put(num - k, diff.getOrDefault(num - k,0) + 1);
            diff.put(num + k + 1, diff.getOrDefault(num + k + 1,0) - 1);
        }
        TreeSet<Integer> keys = new TreeSet<>();
        keys.addAll(diff.keySet());
        keys.addAll(cnt.keySet());
        int adjustable = 0;
        int ans = 0;
        for (int x : keys) {
            adjustable += diff.getOrDefault(x, 0);
            int countX = cnt.getOrDefault(x, 0);
            int reachable = adjustable - countX;
            if (reachable < 0) reachable = 0;
            ans = Math.max(ans, countX + Math.min(numOperations, reachable));
        }
        return ans;
    }
}
