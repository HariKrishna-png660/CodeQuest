class Solution {
    // minimise the maximum
    public boolean isPossible(int nums[],int minDis,int p) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n-1;i++) {
            if(nums[i+1]-nums[i]<=minDis) {
                count++;
                i++;
            }
        }
        return count>=p;
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n=nums.length;
        int low=0;
        int high=(int)(1e9);
        int minDis=0;
        while(low<=high) {
            int mid=(low+high)/2;
            if(isPossible(nums,mid,p)) {
                minDis=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return minDis;
    }
}