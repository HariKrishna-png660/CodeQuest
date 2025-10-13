class Solution {
    // // this is a problem in which we need to binary search on the answer
    // // this is a problem in which we need to minimize the maximum
    // public boolean isPossible(int ranks[],long min,int cars) {
    //     int n=ranks.length;
    //     long sum=0;
    //     for(int i=0;i<n;i++) {
    //         sum +=(int)(Math.sqrt(min/ranks[i]));
    //     }
    //     return sum >=cars;
    // }
    // public long repairCars(int[] ranks, int cars) {
    //      long si=1;
    //      long ei=(long)(1e18);
    //      long minTime=0;
    //      while(si<=ei) {
    //         long mid=(si+ei)/2;
    //         if(isPossible(ranks,mid,cars)) {
    //             minTime=mid;
    //             ei=mid-1;
    //         }
    //         else {
    //             si=mid+1;
    //         }
    //      }
    //      return minTime;
    // }
     public boolean isPossible(int ranks[],long minTime,int cars) {
           long totalCars=0;
           int n=ranks.length;
           for(int i=0;i<n;i++) {
               totalCars += Math.sqrt(((double)minTime/(double)ranks[i]));
           }
           return totalCars >=cars;
     }
     public long repairCars(int[] ranks, int cars) {
           int n=ranks.length;
           long low=1; 
           long high=(long)(1e18);
           long ans=0;
           while(low<=high) {
               long mid=(low+high)/2;
               if(isPossible(ranks,mid,cars)) {
                  ans=mid;
                  high=mid-1;
               }
               else {
                  low=mid+1;
               }
           }
           return ans;
     }
}