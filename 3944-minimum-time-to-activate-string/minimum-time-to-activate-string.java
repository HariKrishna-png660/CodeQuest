class Solution {
    public boolean isActiveAtTime(int t, String s, int[] order, int k) {
        int n = s.length();
        boolean[] isStar = new boolean[n];
        for (int i = 0; i <= t; i++) {
            isStar[order[i]] = true;
        }

        long invalidCount = 0;
        long segmentLength = 0;

        for (int i = 0; i < n; i++) {
            if (!isStar[i]) {
                segmentLength++;
            } else {
                invalidCount += (segmentLength * (segmentLength + 1)) / 2;
                segmentLength = 0;
            }
        }
        if (segmentLength > 0) {
            invalidCount += (segmentLength * (segmentLength + 1)) / 2;
        }

        long totalSubstrings = ((long) n * (n + 1)) / 2;
        long validSubstrings = totalSubstrings - invalidCount;

        return validSubstrings >= k;
    }

    public int minTime(String s, int[] order, int k) {
        int n = s.length();
        int left = 0, right = n - 1, answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isActiveAtTime(mid, s, order, k)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
