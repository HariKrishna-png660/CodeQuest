class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length;
        int si=0;
        int ei=0;
        int count=0;
        int sum=0;
        int maxSum=0;
        int freq[]=new int[10001];
        while(ei<n) {
            if(freq[nums[ei]]==1) {
                count++;
            }
            sum += nums[ei];
            freq[nums[ei]]++;
            ei++;
            while(count>0) {
                if(freq[nums[si]]==2) {
                    count--;
                }
                freq[nums[si]]--;
                sum -= nums[si];
                si++;
            }
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
}