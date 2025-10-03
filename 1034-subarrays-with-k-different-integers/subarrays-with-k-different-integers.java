class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtMost(nums,k)-subarraysWithAtMost(nums,k-1);
    }
    public int subarraysWithAtMost(int nums[],int k) {
        int goodSubarrays=0;
        int n=nums.length;
        int si=0;
        int ei=0;
        int count=0;
        int freq[]=new int[(int)(1e5)];
        while(ei<n) {
            if(freq[nums[ei]]==0) {
                count++;
            }
            freq[nums[ei]]++;
            ei++;
            while(count>k) {
                if(freq[nums[si]]==1) {
                    count--;
                }
                freq[nums[si]]--;
                si++;
            }
               goodSubarrays += (ei-si);
        }
        return goodSubarrays;
    }
}