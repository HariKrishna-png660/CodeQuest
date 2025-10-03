class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int si=0;
        int ei=0;
        int freq[]=new int[100001];
        int count=0;
        long sum=0;
        long maxSum=0;
        while(ei<n) {
            if(freq[nums[ei]]==1) {
                count++;
            }
            freq[nums[ei]]++;
            sum += nums[ei];
            ei++;
            while(count>0) {
                if(freq[nums[si]]==2) {
                    count--;
                }
                freq[nums[si]]--;
                sum -= nums[si];
                si++;
            }
             
             if(ei-si>k) {
                freq[nums[si]]--;
                sum -= nums[si];
                si++;
            }
             if(ei-si==k) {
               maxSum =Math.max(maxSum,sum);
            } 
        }
        return maxSum;
    }
}