class Solution {
    // ========================TIME COMPLEXITY IS O(N LOG N)=============================================
    // public int isPossible(int nums[],int k) {
    //     int n=nums.length;
    //     int count=0;
    //     for(int i=0;i<n;i++) {
    //         if(nums[i]>=k) {
    //             count++;
    //         }
    //     }
    //     return count;
    // }
    // public int specialArray(int[] nums) {
    //     Arrays.sort(nums);
    //     int low=1;
    //     int high=1000;
    //     while(low<=high) {
    //         int mid=(low+high)/2;
    //         int val=isPossible(nums,mid);
    //         if(val==mid) {
    //             return mid;
    //         }
    //         else if(val<mid) {
    //             high=mid-1;
    //         }
    //         else {
    //             low=mid+1;
    //         }
    //     }
    //     return -1;
    // }
    // ================TIME COMPLEXITY IS O(N)=============
      public int specialArray(int[] nums) {
          int n=nums.length;
          int count[]=new int[1001];
          for(int i=0;i<n;i++) {
             int val=nums[i];
             count[val]++;
          }
          int c=0;
          for(int i=1000;i>=0;i--) {
              c += count[i];
              if(c==i) {
                  return i;
              }
          }
          return -1;
      }
}