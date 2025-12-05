class Solution {
    public int getSum(int nums[],int start,int end) {
        int sum=0;
        for(int i=start;i<=end;i++) {
             sum += nums[i];
        }
        return sum;
    }
    public int countPartitions(int[] nums) {
          int n=nums.length;
          int count=0;
          for(int i=0;i<n-1;i++) {
               int leftSum=getSum(nums,0,i);
               int rightSum=getSum(nums,i+1,n-1);
               int diff=Math.abs(leftSum-rightSum);
               if(diff%2==0) {
                   count++; 
               }
          }
          return count;
    }
}