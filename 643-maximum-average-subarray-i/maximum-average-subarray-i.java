class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        double maxAverage=Double.NEGATIVE_INFINITY;
        int si=0;
        int ei=0;
        int sum=0;
        while(ei<n) {
            sum +=nums[ei];
            ei++;
            if(ei-si==k) {
                maxAverage=Math.max(maxAverage,(double)sum/k);
                sum -= nums[si];
                si++;
            }
        }
        return maxAverage;

    }
}