class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    public int atMost(int[] nums, int goal) {
        if(goal < 0) return 0;

        int si = 0, sum = 0, count = 0;

        for(int ei = 0; ei < nums.length; ei++) {
            sum += nums[ei];

            while(sum > goal) {
                sum -= nums[si++];
            }

            count += (ei - si + 1);
        }

        return count;
    }
}