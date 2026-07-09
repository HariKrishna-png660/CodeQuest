class Solution {
    public int getRange(int num) {
        int small=Integer.MAX_VALUE;
        int large=Integer.MIN_VALUE;
        while(num>0) {
            int digit=num%10;
            num=num/10;
            small=Math.min(small,digit);
            large=Math.max(large,digit);
        }
        return large-small;
    }
    public int maxDigitRange(int[] nums) {
        int n=nums.length;
        int maxDigitRange=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            int number=nums[i];
            maxDigitRange=Math.max(maxDigitRange,getRange(number));
        }
        int ans=0;
        for(int i=0;i<n;i++) {
            if(getRange(nums[i])==maxDigitRange) {
                ans += nums[i];
            }
        }
        return ans;
    }
}