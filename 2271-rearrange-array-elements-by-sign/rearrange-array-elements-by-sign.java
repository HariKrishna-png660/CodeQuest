class Solution {
    // public int[] rearrangeArray(int[] nums) {
    //     int n=nums.length;
    //     int arr[]=new int[n];
    //     int p=0;
    //     int q=n/2;
    //     for(int i=0;i<nums.length;i++) {
    //         if(nums[i]>0) {
    //             arr[p++]=nums[i];
    //         }
    //         else {
    //             arr[q++]=nums[i];
    //         }
    //     }
    //     p=0;
    //     q=n/2;
    //     int i=0;
    //     while(i<n) {
    //         nums[i++]=arr[p++];
    //         nums[i++]=arr[q++];
    //     }
    //     return nums;
    // }
    public int[] rearrangeArray(int nums[]) {
        int n=nums.length;
        int arr[]=new int[n];
        int pi=0;
        int ni=1;
        for(int i=0;i<n;i++) {
            if(nums[i]>0) {
                arr[pi]=nums[i];
                pi+=2;
            }
            else {
                arr[ni]=nums[i];
                ni += 2;
            }
        }
        return arr;
    }
}