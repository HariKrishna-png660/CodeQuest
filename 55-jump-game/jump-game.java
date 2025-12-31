class Solution {
    public boolean canCross(int nums[],int lastZeroIndex) {
        int n=nums.length;
        for(int i=lastZeroIndex-1;i>=0;i--) {
                if(i+nums[i]>lastZeroIndex || i+nums[i]==n-1) {
                    return true;
                }
            }
            return false;
    }
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n==1) {
            return true;
        }
        int lastZeroIndex=-1;
        for(int i=0;i<n;i++) {
            if(nums[i]==0 && !canCross(nums,i)) {
                return false;
            }
        }
       return true;
    }
}