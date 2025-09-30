class Solution {
    // this is one of the problem in which we are doing binary search on the answer
    // this is a problem in which we need to minimize the maximum
    public boolean isPossible(int weights[],int min,int days) {
        int n=weights.length;
        int sum=0;
        for(int i=0;i<n;i++) {
            sum += weights[i];
            if(sum>min) {
                days--;
                sum=weights[i];
            }
        }
        return days>0;
    }
    public int shipWithinDays(int[] weights, int days) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<weights.length;i++) {
            max=Math.max(max,weights[i]);
        }
        int si=max;
        int ei=(int)(1e9);
        int minCapacity=0;
        while(si<=ei) {
            int mid=(si+ei)/2;
            if(isPossible(weights,mid,days)) {
                minCapacity=mid;
                ei=mid-1;
            }
            else {
                si=mid+1;
            }
        }
        return minCapacity;
    }
}