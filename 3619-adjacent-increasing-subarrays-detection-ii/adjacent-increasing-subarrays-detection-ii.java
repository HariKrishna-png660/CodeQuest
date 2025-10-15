class Solution {
    // ==============TIME COMPLEXITY IS O(N LOG N)===================
    // public boolean isPossible(List<Integer> nums,int k) {
    //     int n=nums.size();
    //     int currRun=1;
    //     int prevRun=-1;
    //     for(int i=1;i<n;i++) {
    //         if(nums.get(i)>nums.get(i-1)) {
    //             currRun++;
    //         }
    //         else {
    //             prevRun=currRun;
    //             currRun=1;
    //         }
    //         if(currRun/2>=k) {
    //             return true;
    //         }
    //         if(Math.min(prevRun,currRun)>=k) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    // public int maxIncreasingSubarrays(List<Integer> nums) {
    //     int n=nums.size();
    //     int low=1;
    //     int high=(int)(1e5);
    //     int ans=0;
    //     while(low<=high) {
    //         int mid=(low+high)/2;
    //         if(isPossible(nums,mid)) {
    //              ans=mid;
    //              low=mid+1;
    //         }
    //         else {
    //             high=mid-1;
    //         }
    //     }
    //     return ans;
    // }
    // ==============TIME COMPLEXITY IS O(N)=====================
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n=nums.size();
        int currRun=1;
        int prevRun=0;
        int ans=-1;
        for(int i=1;i<n;i++) {
            if(nums.get(i)>nums.get(i-1)) {
               currRun++;
            }
            else {
                prevRun=currRun;
                currRun=1;
            }
            if(currRun%2==0) {
               ans=Math.max(ans,currRun/2);
            }
               ans=Math.max(ans,Math.min(currRun,prevRun));
        }
        return ans;
    }
}