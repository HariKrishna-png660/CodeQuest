class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) {
            return 0;
        }
        int n=nums.length;
        int si=0;
        int ei=0;
        int subarrayCount=0;
        int currProduct=1;
        while(ei<n) {
            currProduct *= nums[ei];
            ei++;
            while(currProduct>=k && si<n) {
                int val=nums[si];
                currProduct /= val;
                si++;
            }
            if(ei>si) {
                subarrayCount += (ei-si);
            }
            System.out.println(subarrayCount);
        }
       return subarrayCount;
    }
}