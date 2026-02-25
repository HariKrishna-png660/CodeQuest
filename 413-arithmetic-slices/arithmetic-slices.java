class Solution {
    public int getCountOfAllArthimeticSubArrays(int si,int ei) {
        int n=ei-si;
        if(n<3){
            return 0;
        }
        return ((n-1)*(n-2))/2;
    }
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        int si=0;
        int ans=0;
        if(n<3) {
            return 0;
        }
        int diff=nums[1]-nums[0];
        int ei=2;
        while(ei<n) {
            if(nums[ei]-nums[ei-1]!=diff) {
                ans += getCountOfAllArthimeticSubArrays(si,ei);
                si=ei-1;
                diff=nums[ei]-nums[si];
            }
            ei++;
        }
         ans += getCountOfAllArthimeticSubArrays(si,ei);
         return ans;
    }
}