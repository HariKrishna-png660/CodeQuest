class Solution {
    public int minimumSum(int[] nums) {
        int n=nums.length;
        int leftMin[]=new int[n];
        int rightMin[]=new int[n];
        leftMin[0]=-1;
        rightMin[n-1]=-1;
        int minLeft=nums[0];
        int minRight=nums[n-1];
        for(int i=1;i<n;i++) {
           if(minLeft<nums[i]) {
            leftMin[i]=minLeft;
           }
           else {
            leftMin[i]=-1;
           }
           minLeft=Math.min(minLeft,nums[i]);
        }
        for(int i=n-2;i>=0;i--) {
            if(minRight<nums[i]) {
                rightMin[i]=minRight;
            }
            else {
                rightMin[i]=-1;
            }
            minRight=Math.min(minRight,nums[i]);
        }
        int sum=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            if(leftMin[i]!=-1 && rightMin[i]!=-1) {
                sum=Math.min(sum,leftMin[i]+rightMin[i]+nums[i]);
            }
        }
        return sum==Integer.MAX_VALUE?-1:sum;
    }
}