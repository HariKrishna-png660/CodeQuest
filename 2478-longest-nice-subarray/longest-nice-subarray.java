class Solution {
    // =====================BRUTE FORCE APPROACHES======================================================================================
    // ONLY BITMASK
    // TIME COMPLEXITY IS O(N^2)
    // public int longestNiceSubarray(int nums[]) {
    //     int n=nums.length;
    //     int maxLength=1;
    //     for(int i=0;i<n;i++) {
    //         int mask=0;
    //         for(int j=i;j<n;j++) {
    //             if((mask & nums[j])==0) {
    //                 mask=mask|nums[j];
    //                 maxLength=Math.max(maxLength,j-i+1);
    //             }
    //             else {
    //                 break;
    //             }
    //         }
    //     }
    //     return maxLength;
    // }
    // ====================(BINARY SEARCH ON THE ANSWER + SLIDING WINDOW) ==============================================================
    // TIME COMPLEXITY IS O(N^2 LOGN)
    // // maximise the minimum
    // public boolean isPossible(int nums[],int maxLength) {
    //     int n=nums.length; // time complexity is O(n^2)
    //     int length=1;
    //     for(int i=0;i<n;i++) {
    //         int mask=0;
    //         for(int j=i;j<n;j++) {
    //             if((mask & nums[j])==0) {
    //                 mask=mask|nums[j];
    //                 if(j-i+1==maxLength) {
    //                     return true;
    //                 }
    //             }
    //             else {
    //                 break;
    //             }
    //         }
    //     }
    //     return false;
    // }
    // public int longestNiceSubarray(int[] nums) {
    //     int n=nums.length;
    //     int si=1;
    //     int ei=n;
    //     int ans=0;
    //     while(si<=ei) {
    //         int mid=(si+ei)/2;
    //         if(isPossible(nums,mid)) {
    //             ans=mid;
    //             si=mid+1;
    //         }
    //         else {
    //             ei=mid-1;
    //         }
    //     }
    //     return ans;
    // }
    //========================OPTIMISED APPROACH (SLIDING WINDOW + BIT MASK)=================================================
    // TIME COMPLEXITY IS O(N)
    public int longestNiceSubarray(int nums[]) {
        int n=nums.length;
        int si=0;
        int ei=0;
        int mask=0;
        int maxLength=1;
        while(ei<n) {
            while((mask & nums[ei])!=0) {
                mask = mask ^ nums[si];
                si++;
            }
            mask = mask | nums[ei];
            ei++;
            maxLength=Math.max(maxLength,ei-si);
        }
        return maxLength;
    }
}