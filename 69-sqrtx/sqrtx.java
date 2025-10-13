class Solution {
    public boolean isPossible(int min,int x) {
        return (long)min*min<=x;
    }
    public int mySqrt(int x) {
        int low=1;
        int high=x;
        int ans=0;
        while(low<=high) {
            int mid=low+(high-low)/2;
            if(isPossible(mid,x)) {
                ans=mid;
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return ans;
    }
}