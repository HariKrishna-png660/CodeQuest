class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int si=0;
        int ei=0;
        int sum=0;
        int minLen=n+1;
        while(ei<n) {
            sum += nums[ei];
            ei++;
            while(sum>target) {
                 if(sum>target) {
                minLen=Math.min(minLen,ei-si);
               }
                sum -= nums[si++];
            }
            if(sum>=target) {
                minLen=Math.min(minLen,ei-si);
            }
        }
        return minLen==n+1?0:minLen;
    }
}