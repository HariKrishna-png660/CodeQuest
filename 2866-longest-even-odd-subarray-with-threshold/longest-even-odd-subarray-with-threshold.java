class Solution {
    public boolean isAlternating(int nums[],int threshold,int start,int end) {
        for(int i=start;i<=end;i++) {
            if(nums[start]%2!=0) {
                return false;
            }
            if(nums[i]>threshold) {
                return false;
            }
            if(i<=end-1) {
               int curr=nums[i];
               int next=nums[i+1];
               if(curr%2==next%2) {
                   return false;
                }
            }
        }
        return true;
    }
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n=nums.length;
        int maxLen=0;
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
               if(isAlternating(nums,threshold,i,j)) {
                   maxLen=Math.max(maxLen,j-i+1);
               }
            }
        }
        return maxLen;
    }
}