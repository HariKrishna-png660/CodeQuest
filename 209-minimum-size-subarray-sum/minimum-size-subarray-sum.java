class Solution {
    public boolean isPossible(int nums[],int len,int target) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<len;i++) {
            sum += nums[i];
        }
        if(sum >=target) {
            return true;
        }
        for(int i=len;i<n;i++) {
            sum += nums[i] -nums[i-len];
            if(sum>=target) {
                return true;
            }
        }
        return false;
    }
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int low=1;
        int high=n;
        int ans=0;
        while(low<=high) {
            int mid=(low+high)/2;
            if(isPossible(nums,mid,target)) {
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