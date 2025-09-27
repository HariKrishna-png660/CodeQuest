class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int si=0;
        int ei=n-1;
        if(target<nums[0]) {
            return 0;
        }
        if(target>nums[n-1]) {
            return n;
        }
        while(si<ei) {
            int mid=(si+ei)/2;
             if(nums[mid]<target) {
                si=mid+1;
             }
             else {
                ei=mid;
             }
        }
        return si;
    }
}