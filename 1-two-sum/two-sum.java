class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int a=-1;
        int b=-1;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if(nums[i]+nums[j]==target) {
                    a=i;
                    b=j;
                    break;
                }
            }
        }
        return new int[]{a,b};
    }
}