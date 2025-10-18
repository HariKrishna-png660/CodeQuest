class Solution {
    // time complexity is O(N)
    public int maxDistinctElements(int[] nums, int k) {
         // sort the array
         Arrays.sort(nums);
         int n=nums.length;
         int prev=Integer.MIN_VALUE;
         int ans=0;
         for(int i=0;i<n;i++) {
             int minVal=nums[i]-k;
             if(prev<minVal) {
                prev=minVal;
                ans++;
             }
             else if(prev>=minVal) {
                int currVal=prev+1;
                if(currVal>=nums[i]-k && currVal<=nums[i]+k) {
                    ans++;
                    prev=currVal;
                }
             }
         }
         return ans;
    }
}