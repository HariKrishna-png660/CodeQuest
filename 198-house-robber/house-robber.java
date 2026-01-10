class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int inc=nums[0];
        int exc=0;
        for(int i=1;i<n;i++) {
            int prev=inc;
            inc=exc+nums[i];
            exc=Math.max(prev,exc);
        }
        return Math.max(inc,exc);
    }
}