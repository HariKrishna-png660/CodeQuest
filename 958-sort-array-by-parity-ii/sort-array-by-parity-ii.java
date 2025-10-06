class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        int ei=0;
        int oi=1;
        for(int i=0;i<n;i++) {
            if(nums[i]%2==0) {
                arr[ei]=nums[i];
                ei=ei+2;
            }
            else {
                arr[oi]=nums[i];
                oi=oi+2;
            }
        }
        return arr;
    }
}