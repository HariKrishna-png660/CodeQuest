class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int si=0;
        int ei=n-1;
        while(si<ei) {
            int mid=(si+ei)/2;
            if(nums[mid]>nums[ei]) {
                 si=mid+1;
            }
            else if(nums[si]<nums[mid]){
                ei=mid;
            }
            else {
                ei--;
            }
        }
        return nums[si];
    }
}