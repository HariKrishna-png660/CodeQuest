class Solution {
    public boolean isAscending(int nums[],int si,int ei) {
        for(int i=si+1;i<=ei;i++) {
            if(nums[i]-nums[i-1]!=1) {
                return false;
            } 
        }
        return true;
    }
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[n-k+1];
        for(int i=0;i<=n-k;i++) {
            if(isAscending(nums,i,i+k-1)) {
                ans[i]=nums[i+k-1];
            }
            else {
                ans[i]=-1;
            }
        }
        return ans;
    }
}