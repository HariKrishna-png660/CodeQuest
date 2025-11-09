class Solution {
    public boolean isSpecial(int nums[],int start,int end,int k) {
        int xor=nums[start];
        for(int i=start+1;i<=end;i++) {
            xor = xor|nums[i];
        }
        return xor>=k;
    }
    public int minimumSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int minLen=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(isSpecial(nums,i,j,k)) {
                   minLen=Math.min(minLen,j-i+1);
                }
            }
        }
        return minLen==Integer.MAX_VALUE?-1:minLen;
    }
}