class Solution {
    public boolean isPossible(int candies[],long k,int X) {
          for(int c:candies) {
            int piles=c/X;
            k-=piles;
          }
          return k<=0;
    }
    public int maximumCandies(int[] candies, long k) {
        int min=1;
        int max=(int)(1e7); // this can also be the largest value in the array
        int maxPossible=0;
        while(min<=max) {
            int mid=(min+max)/2;
            if(isPossible(candies,k,mid)) {
                maxPossible=mid;
                min=mid+1;
            }
            else {
                max=mid-1;
            }
        }
       return maxPossible;
    }
}