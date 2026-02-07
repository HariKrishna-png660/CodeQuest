class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        if(nums[0]>target) {
            return 0;
        }
        if(nums[n-1]<target) {
            return n;
        }
        int ans=0;
        while(low<=high) {
            int mid=(low+high)/2;
            if(nums[mid]==target) {
                return mid;
            }
            else if(nums[mid]<target) {
                // ans=mid;
                low=mid+1;
            }
            else {
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
}