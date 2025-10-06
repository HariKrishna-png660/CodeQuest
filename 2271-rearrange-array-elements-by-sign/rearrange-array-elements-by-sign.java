class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        int p=0;
        int q=n/2;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>0) {
                arr[p++]=nums[i];
            }
            else {
                arr[q++]=nums[i];
            }
        }
        p=0;
        q=n/2;
        int i=0;
        while(i<n) {
            nums[i++]=arr[p++];
            nums[i++]=arr[q++];
        }
        return nums;
    }
}