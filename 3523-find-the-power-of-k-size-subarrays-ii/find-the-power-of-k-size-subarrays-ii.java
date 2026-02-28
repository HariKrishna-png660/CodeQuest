class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        if(n==1 || k==1) {
            return nums;
        }
        int si=0;
        int ei=1;
        int ans[]=new int[n-k+1];
        while(si<n-k+1 && ei<n) {
            if(nums[ei]-nums[ei-1]!=1) {
                while(si<ei && si<n-k+1) {
                      ans[si]=-1;
                       si++;
                }
            }
            ei++;
            if(ei-si==k) {
                ans[si]=nums[ei-1];
                si++;
            }
        }
       return ans;
    }
}