class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int maxXor=0;
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                int curr=nums[i];
                int next=nums[j];
                int min=Math.min(curr,next);
                if(next-curr<=min) {
                   maxXor=Math.max(maxXor,next^curr);
                }
            }
        }
        return maxXor;
    }
}