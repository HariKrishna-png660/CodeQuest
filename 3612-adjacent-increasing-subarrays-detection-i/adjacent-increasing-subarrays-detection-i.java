class Solution {
    // ================ TIME COMPLEXITY IS O(N^2)======================================
    // public boolean isStrictlyIncreasing(List<Integer> nums,int start,int k) {
    //     int n=nums.size();
    //     for(int i=start;i<start+k-1;i++) {
    //         if(nums.get(i)>=nums.get(i+1)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
    //     int n=nums.size();
    //     for(int i=0;i<=n-2*k;i++) {
    //          if(isStrictlyIncreasing(nums,i,k) && isStrictlyIncreasing(nums,i+k,k)) {
    //             return true;
    //          }
    //     }
    //     return false;
    // }
    // =====================TIME COMPLEXITY IS O(N)======================
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prevRun=0;
        int currentRun=1;
        int n=nums.size();
        for(int i=1;i<n;i++) {
            if(nums.get(i)>nums.get(i-1)) {
                currentRun++;
            }
            else {
                prevRun=currentRun;
                currentRun=1;
            }
             if(currentRun/2>=k) {
                    return true;
                }
             if(Math.min(prevRun,currentRun)>=k) {
                    return true;
             }
        }
        // if(Math.min(prevRun,currentRun)>=k) {
        //     return true;
        // }
        return false;
    }
}