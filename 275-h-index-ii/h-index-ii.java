class Solution {
    // Check if h is a possible H-Index
    public boolean isPossible(int[] citations, int h) {
        int count = 0;
        for (int c : citations) {
            if (c >= h) count++;
        }
        return count >= h;
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n;
        int maxH = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(citations, mid)) {
                maxH = mid;      // mid is possible, try higher
                left = mid + 1;
            } else {
                right = mid - 1; // mid not possible, try lower
            }
        }

        return maxH;
    }
}
