class Solution {
    // // this is one of the problem in which we doing binary search on the answer
    // // this is a problem in which we need to minimize the maximum
    // public boolean isPossible(int bloomDay[],int min,int m,int k) {
    //     int n=bloomDay.length;
    //     int count=0;
    //     for(int i=0;i<n;i++) {
    //         int val=bloomDay[i];
    //         if(val<=min) {
    //             count++;
    //             if(count==k) {
    //                 m--;
    //                 count=0;
    //             }
    //         }
    //         else {
    //             count=0;
    //         }
    //     }
    //     return m<=0;
    // }
    // public int minDays(int[] bloomDay, int m, int k) {
    //     int si=1;
    //     int ei=(int)(1e9);
    //     int minDay=-1;
    //     while(si<=ei) {      // time complexity is O(n log n)
    //         int mid=(si+ei)/2;
    //         if(isPossible(bloomDay,mid,m,k)) {
    //             minDay=mid;
    //             ei=mid-1;
    //         }
    //         else {
    //             si=mid+1;
    //         }
    //     }
    //     return minDay;
    // }
    public boolean isPossible(int bloomDay[],int minDay,int k,int m) {
        int n=bloomDay.length;
        int K=k;
        for(int i=0;i<n;i++) {
             if(bloomDay[i]<=minDay) {
                K--;
                if(K==0) {
                 m--;
                 K=k;
               }
             }
             else {
                K=k;
             }
        }
        return m<=0;
    }
    public int minDays(int[] bloomDay, int m, int k) {
         int low=1; // when bloomDay={1} m=1 and k=1
         int high=(int)(1e9); // when bloomDay={10^9} m=1 and k=1
         int ans=-1;
         while(low<=high) {
            int mid=(low+high)/2;
            if(isPossible(bloomDay,mid,k,m)) {
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