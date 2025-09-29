class Solution {
    // while finding the first index we will move towards left
    // while finding the last index we will move towards right
    public int getFirstIndex(int arr[],int target) {
        int n=arr.length;
        int si=0;
        int ei=n-1;
        int firstIndex=-1;
        while(si<=ei) {
            int mid=(si+ei)/2;
            if(arr[mid]==target) {
                firstIndex=mid;
                ei=mid-1; // search for some better smaller index
            }
            else if(arr[mid]>target) {
                ei=mid-1;
            }
            else {
                si=mid+1;
            }
        }
        return firstIndex;
    }
    public int getLastIndex(int arr[],int target) {
        int n=arr.length;
        int si=0;
        int ei=n-1;
        int lastIndex=-1;
        while(si<=ei) {
            int mid=(si+ei)/2;
            if(arr[mid]==target) {
                lastIndex=mid;
                si=mid+1; // search for some better larger index
            }
            else if(arr[mid]>target) {
                ei=mid-1;
            }
            else {
                si=mid+1;
            }
        }
        return lastIndex;
    }
    public int[] searchRange(int[] nums, int target) {
        int firstIndex=getFirstIndex(nums,target);
        int lastIndex=getLastIndex(nums,target);
        return new int[]{firstIndex,lastIndex};
    }
}