class Solution {
    public boolean isPossible(long time,int mountainHeight,int workerTimes[]) {
         long reduced = 0;

        for(int t : workerTimes) {

            long x = (long)((-1 + Math.sqrt(1 + (8.0 * time) / t)) / 2);

            reduced += x;

            if(reduced >= mountainHeight) {
                return true;
            }
        }

        return false;
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
         // may be binary search on the answer ?? 
         // lowest answer can be 1 
         // highest answer can be 1e18
         long low=1;
         long high=(long)1e18;
         long ans=low;
         while(low<=high) {
            long mid=(low+high)/2;
            if(isPossible(mid,mountainHeight,workerTimes)) {
                  ans=mid;
                  high=(mid-1);
            }
            else {
                 low=mid+1;
            }
         }
         return ans;
    }
}