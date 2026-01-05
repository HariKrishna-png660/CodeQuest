class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int maxSum=Integer.MIN_VALUE;
        int meh=0;
        for(int i=0;i<n;i++) {
            meh=meh+nums[i];
            maxSum=Math.max(meh,maxSum);
            if(meh<0) {
                meh=0;
            }
        }
        return maxSum;
    }
}