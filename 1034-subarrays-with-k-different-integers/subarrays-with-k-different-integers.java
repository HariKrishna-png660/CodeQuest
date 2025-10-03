class Solution {
    // for the test case [1,2,1,2,3] and k=2 
    // window can detect the following subarrays
    // [1] [1,2] [1,2,1] [1,2,1] [1,2,1,2] [2,3]
    // all subarrays with atmost k differnt integers for a given subarray is length of the window
    // all the subarrays with atmost 2 differnt integers
    //  for [1] -> [1]
    //  for [1,2] ->[1,2] , [2]
    //  for [1,2,1] -> [1,2,1] , [2,1] ,[1]
    //  for [1,2,1,2] -> [1,2,1,2] , [2,1,2] ,[1,2] ,[2]
    //  for [2,3] -> [2,3] , [3]
    // count=12
    // all the subarrays with atmost 1 different integer
    // window can detect the following subarrays
    // [1] [2] [1] [2] [3]
    // count=5
    // subarrays with exact k integers = atmost k - atmost k-1
    // ans=[1,2] [1,2,1] [2,1] [1,2,1,2] [2,1,2] [1,2] [2,3] 
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