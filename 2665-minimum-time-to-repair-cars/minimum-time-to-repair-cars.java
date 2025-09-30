class Solution {
    // this is a problem in which we need to binary search on the answer
    // this is a problem in which we need to minimize the maximum
    public boolean isPossible(int ranks[],long min,int cars) {
        int n=ranks.length;
        long sum=0;
        for(int i=0;i<n;i++) {
            sum +=(int)(Math.sqrt(min/ranks[i]));
        }
        return sum >=cars;
    }
    public long repairCars(int[] ranks, int cars) {
         long si=1;
         long ei=(long)(1e18);
         long minTime=0;
         while(si<=ei) {
            long mid=(si+ei)/2;
            if(isPossible(ranks,mid,cars)) {
                minTime=mid;
                ei=mid-1;
            }
            else {
                si=mid+1;
            }
         }
         return minTime;
    }
}