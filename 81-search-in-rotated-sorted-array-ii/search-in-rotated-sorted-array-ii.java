class Solution {
    // code written for leetcode 33 
    // will fail for test case 
    // [1,0,1,1,1]
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        int si=0;
        int ei=n-1;
        while(si<=ei) {   // time complexity is average case O(log n)  worst case O(n)
            int mid=(si+ei)/2;
            if(nums[mid]==target || nums[si]==target) {
                 return true;
            }
            else if(nums[si]<nums[mid]) { // left part is sorted 
                if(nums[si]<=target && nums[mid]>target) {
                    ei=mid-1;
                }
                else {
                    si=mid+1;
                }
            }
            else if(nums[mid]<nums[ei]) { // right part is sorted 
                if(nums[mid]<target && nums[ei]>=target) {
                    si=mid+1;
                }
                else {
                    ei=mid-1;
                }
            }
            else {  // either si and mid are coinciding or area is not sorted 
                si++;
            }
        }
        return false;
    }
}