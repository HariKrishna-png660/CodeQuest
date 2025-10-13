class Solution {
    /*
        TEST CASE EXPLANATION:
          candies = [5,8,6], k = 3
          when ans=2 then we can distribute to 3 children easily
          when ans=3 then we can distribute to 3 children easily
          when ans=4 then we can distribute to 3 children easily
          when ans=5 then we can distribute to exactly 3 children 
          when ans=6 then we can distribute to exactly 2 children 
    */
    // // this is one of the problem in which we find ans by doing binary search on the answer 
    // // this is basically maximizing the minimum....
    // public boolean isPossible(int candies[],int min,long k) {
    //     int n=candies.length;
    //     for(int i=0;i<n;i++) {
    //         int val=candies[i]/min;
    //         k-=val;
    //     }
    //     return k<=0;
    // }
    // public int maximumCandies(int[] candies, long k) {
    //     int n=candies.length;
    //     int left=1;
    //     int right=(int)(1e7);  // can also be optimised 
    //     int maxCandies=0;
    //     while(left<=right) {    // time complexity is O(n log n)
    //         int mid=(left+right)/2;
    //         if(isPossible(candies,mid,k)) {
    //             maxCandies=mid;
    //             left=mid+1;
    //         }
    //         else {
    //             right=mid-1;
    //         }
    //     }
    //     return maxCandies;
    // }
    public boolean isPossible(int candies[],int maxCandies,long k) {
        int n=candies.length;
        for(int i=0;i<n;i++) {
            int distribution=candies[i]/maxCandies;
            k -= distribution;
        }
        return k<=0;
    }
    public int maximumCandies(int[] candies, long k) {
        // binary search on the answer 
        // maximize the minimum
        int low=1; // candies={1} and k=1 
        int high=(int)(1e7); // candies={10^7} and k=1
        int ans=0;
        while(low<=high) {
            int mid=(low+high)/2;
            if(isPossible(candies,mid,k)) {
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