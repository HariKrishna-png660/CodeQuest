class Solution {
    public int arrangeCoins(int n) {
        long low=1;
        long high=n;
        long ans=0;
        while(low<=high) {
            long mid=low+(high-low)/2;
            long sum=(mid)*(mid+1)/2;
            if(sum==n) {
                ans=mid;
                break;
            }
            else if(sum<n) {
                low=mid+1;
                ans=mid;
            }
            else {
                high=mid-1;
            }
        }
        return (int)ans;
    }
}