class Solution {
    public boolean isPossible(int x, int min) {
        return (long)min * min <= x; 
    }
    
    public int mySqrt(int x) {
        int low = 0, high = x, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2; 
            if (isPossible(x, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
