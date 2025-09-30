class Solution {
    // minimise the maximum
    public boolean isPossible(int nums[],int max,int op) {
        int n=nums.length;
        for(int i=0;i<n;i++) {
            op-=(nums[i]-1)/max;
        }
        return op>=0;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int low=1;
        int high=(int)(1e9);
        int maxBalls=0;
        while(low<=high) {
            int mid=(low+high)/2;
            if(isPossible(nums,mid,maxOperations)) {
                maxBalls=mid;
                high=mid-1;
            }
            else {
               low=mid+1;
            }
        }
        return maxBalls;
    }
}