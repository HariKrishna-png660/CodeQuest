class Solution {
    public int getSum(int nums[],int start,int end) {
        int ans=0;
        for(int i=start;i<=end;i++) {
            ans += nums[i];
        }
        return ans;
    }
    public int getSubArraySum(int nums[],int len) {
        int n=nums.length;
        int minSum=Integer.MAX_VALUE;
        for(int i=0;i<=n-len;i++) {
            int sum=getSum(nums,i,i+len-1);
            if(sum>0) {
                minSum=Math.min(minSum,sum);
            }
        }
        return minSum==Integer.MAX_VALUE?-1:minSum;
    }
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int num[]=new int[n];
        for(int i=0;i<n;i++) {
            num[i]=nums.get(i);
        }
        int minSum=Integer.MAX_VALUE;
        for(int i=l;i<=r;i++) {
             int subArraySum=getSubArraySum(num,i);
             if(subArraySum>0) {
                minSum=Math.min(minSum,subArraySum);
             }
        }
        return minSum==Integer.MAX_VALUE?-1:minSum;
    }
}