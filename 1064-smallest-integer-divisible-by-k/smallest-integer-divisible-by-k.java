class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        java.util.Set<Integer> seen = new java.util.HashSet<>();
        int remainder = 0;
        for (int length = 1; length <= k; length++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) return length;
            if (seen.contains(remainder)) return -1;
            seen.add(remainder);
        }
        return -1;
    }
}
