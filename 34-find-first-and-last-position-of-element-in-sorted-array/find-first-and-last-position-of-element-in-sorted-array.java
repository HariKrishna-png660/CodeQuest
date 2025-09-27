class Solution {
    public int findFirstIndex(int nums[],int target) {
        int n=nums.length;
        int si=0;
        int ei=n-1;
        int firstIndex=-1;
        while(si<=ei) {
            int mid=(si+ei)/2;
            if(nums[mid]==target) {
               firstIndex=mid;
               ei=mid-1;
            }
            else if(nums[mid]<target) {
                si=mid+1;
            }
            else {
                ei=mid-1;
            }
        }
        return firstIndex;
    }
    public int findLastIndex(int nums[],int target) {
        int n=nums.length;
        int si=0;
        int ei=n-1;
        int lastIndex=-1;
        while(si<=ei) {
            int mid=(si+ei)/2;
            if(nums[mid]==target) {
                lastIndex=mid;
                si=mid+1;
            }
            else if(nums[mid]<target) {
                si=mid+1;
            }
            else {
                ei=mid-1;
            }
        }
        return lastIndex;
    }
    public int[] searchRange(int[] nums, int target) {
        int firstIndex=findFirstIndex(nums,target);
        int lastIndex=findLastIndex(nums,target);
        return new int[]{firstIndex,lastIndex};
    }
}