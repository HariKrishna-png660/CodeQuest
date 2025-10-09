class Solution {
    public int maximumCount(int[] nums) {
        int n=nums.length;
        int neg=0;
        int zero=0;
        for(int i=0;i<n;i++) {
            if(nums[i]<0) {
                neg++;
            }
            else if(nums[i]==0) {
                zero++;
            }
            else {
                break;
            }
        }
        return Math.max(neg,n-zero-neg);
    }
}