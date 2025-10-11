class Solution {
    // there will be three scenarios possible ->
    // si to mid sorted and mid to ei is unsorted  answer will be in the right area (unsorted)
    // si to mid unsorted and mid to ei is sorted  answer will be in the left area (unsorted)
    // si to mid is sorted and mid to ei is sorted  answer will be in the left area 
    // we only go to right when it is unsorted and remaing cases we go to left
    // going right means si=mid+1
    // going left means ei=mid
    // public int findMin(int[] nums) {
    //     int si=0;
    //     int ei=nums.length-1;
    //     while(si<ei) { // tc O(log n)
    //         int mid=(si+ei)/2;
    //         if(nums[mid]>nums[ei]) {
    //             si=mid+1;
    //         }
    //         else {
    //             ei=mid;
    //         }
    //     }
    //     return nums[si];
    // }
    public int findMin(int[] nums) {
  int si = 0, ei = nums.length - 1;
    int ans = nums[0];

    while (si <= ei) {
        int mid = si + (ei - si) / 2;

        // If the current window is already sorted,
        // then nums[si] is the minimum in this range.
        if (nums[si] <= nums[ei]) {
            ans = Math.min(ans, nums[si]);
            break;
        }

        // Left half is sorted
        if (nums[si] <= nums[mid]) {
            ans = Math.min(ans, nums[si]);
            si = mid + 1;
        }
        // Right half is sorted
        else {
            ans = Math.min(ans, nums[mid]);
            ei = mid - 1;
        }
    }
    return ans;
}
}