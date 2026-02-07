class Solution {
    public int findFirstIndex(int arr[],int target) {
           int n=arr.length;
           int firstIndex=-1;
           int low=0;
           int high=n-1;
           while(low<=high) {
              int mid=(low+high)/2;
              if(arr[mid]==target) {
                  firstIndex=mid;
                  high=mid-1;
              }
              else if(arr[mid]<target) {
                  low=mid+1;
              }
              else {
                  high=mid-1;
              }
           }
           return firstIndex;
    }
    public int findLastIndex(int arr[],int target) {
           int n=arr.length;
           int lastIndex=-1;
           int low=0;
           int high=n-1;
           while(low<=high) {
               int mid=(low+high)/2;
               if(arr[mid]==target) {
                   lastIndex=mid;
                   low=mid+1;
               }
               else if(arr[mid]<target) {
                  low=mid+1;
               }
               else {
                  high=mid-1;
               }
           }
           return lastIndex;
    }
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int firstIndex=findFirstIndex(nums,target);
        int lastIndex=findLastIndex(nums,target);
        return new int[]{firstIndex,lastIndex};
    }
}