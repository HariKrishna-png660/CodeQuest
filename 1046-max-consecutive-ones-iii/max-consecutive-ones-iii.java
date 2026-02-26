class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int si=0;
        int ei=0;
        int maxLen=0;
        while(ei<n) {
            if(nums[ei]==0) {
                k--;
                while(k<0) {
                    if(nums[si]==0) {
                        k++;
                    }
                    si++;
                }
            }
            ei++;
            maxLen=Math.max(maxLen,ei-si);
        }
        return maxLen;
    }
}