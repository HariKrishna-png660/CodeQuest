class Solution {
    // after rotation there will be one area that is (((0 to mid or mid to ei))) is sorted 
    // we relay on the area that is sorted first to search for the target.
    // if we fail in finding the target in the sorted area then we try to search it in the unsorted area.
    // public int search(int[] nums, int target) {
    //     int n=nums.length;
    //     int si=0;
    //     int ei=n-1;
    //     while(si<=ei) {  // time complexity is O(log n)
    //         int mid=(si+ei)/2;
            
    //         if(nums[mid]==target) {
    //             return mid;
    //         }
    //         else if(nums[si]<=nums[mid]) {  // this means that the left part is sorted .'=' is required because when si and mid coincide then there will be only element in the area which is sorted.
    //            // lets see if target exists
    //            if(nums[si]<=target && nums[mid]>target) {
    //               ei=mid-1;
    //            }  
    //            else {
    //               si=mid+1;
    //            }       
    //         }
    //         else {
    //             if(nums[mid]<target && nums[ei]>=target) {
    //                 si=mid+1;
    //             }
    //             else {
    //                 ei=mid-1;
    //             }
    //         }
    //     }
    //     return -1;
    // }
    public int search(int[] nums, int target) {
        int n=nums.length;
        int si=0;
        int ei=n-1;
        while(si<=ei) {
            int mid=(si+ei)/2;
            if(nums[mid]==target) {
                return mid;
            }
            else if(nums[mid]>=nums[si]) {
                 if(nums[si]<=target && nums[mid]>target) {
                     ei=mid-1;
                 }
                 else {
                    si=mid+1;
                 }
            }
            else {
                if(nums[mid]<target && nums[ei]>=target) {
                    si=mid+1;
                }
                else {
                    ei=mid-1;
                }
            }
        }
        return -1;
    }
}