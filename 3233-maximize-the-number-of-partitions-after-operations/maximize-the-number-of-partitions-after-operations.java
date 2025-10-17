import java.util.*;

class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        int n = s.length();
        Map<Long, Integer> mem = new HashMap<>();
        return dfs(s, 0, true, 0, k, mem) + 1;
    }

    private int dfs(String s, int i, boolean canChange, int mask, int k, Map<Long, Integer> mem) {
        int n = s.length();
        if (i == n) return 0;
        long key = (((long)i) << 33) | ((canChange ? 1L : 0L) << 32) | (mask & 0xffffffffL);
        if (mem.containsKey(key)) return mem.get(key);
        int res = 0;
        int curBit = 1 << (s.charAt(i) - 'a');
        res = Math.max(res, getRes(s, i, canChange, mask, curBit, k, mem));
        if (canChange) {
            for (int j = 0; j < 26; j++) {
                int bit = 1 << j;
                res = Math.max(res, getRes(s, i, false, mask, bit, k, mem));
            }
        }
        mem.put(key, res);
        return res;
    }

    private int getRes(String s, int i, boolean nextCanChange, int mask, int newBit, int k, Map<Long, Integer> mem) {
        int newMask = mask | newBit;
        if (Integer.bitCount(newMask) > k) {
            return 1 + dfs(s, i + 1, nextCanChange, newBit, k, mem);
        } else {
            return dfs(s, i + 1, nextCanChange, newMask, k, mem);
        }
    }
}
