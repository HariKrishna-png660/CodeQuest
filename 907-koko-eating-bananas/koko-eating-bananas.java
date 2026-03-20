class Solution {
    // // this is simply minimize the maximum .....
    // public boolean isPossible(int arr[],int min,int h) {
    //     long count=0;
    //     for(int i=0;i<arr.length;i++) {
    //         count += (arr[i]/min);
    //         if(arr[i]%min!=0) {
    //             count++;
    //         }
    //     }
    //     if(count<=(int)(h)) {
    //         return true;
    //     }
    //     return false;
    // }
    // public int minEatingSpeed(int[] piles, int h) {
    //     int si=1;   // this is the minimum possible speed with which koko can eat 
    //     int ei=(int)(1e9);  // this is the maximum possible speed with which koko can eat
    //     int ans=0;     
    //     while(si<=ei) {
    //         int mid=(si+ei)/2;
    //         if(isPossible(piles,mid,h)) {
    //             ans=mid;
    //             ei=mid-1;   // try to get the better minimum 
    //         }
    //         else {
    //             si=mid+1;    //  try to search in the right side ....
    //         }
    //     }
    //     return ans;
    // }
    public boolean isPossible(int piles[],int speed,int h) {
        int n=piles.length;
        for(int i=0;i<n;i++) {
            int timeTaken=(int)Math.ceil((double)piles[i]/(double)speed);
            // System.out.println(timeTaken);
            h -= timeTaken;
        }
        return h >= 0;
    }
    public int minEatingSpeed(int[] piles, int h) { 
         int n=piles.length;
         int low=1;
         int high=(int)1e9;
         int ans=1;
         while(low <= high) {
            int mid=(low+high)/2;
            if(isPossible(piles,mid,h)) {
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