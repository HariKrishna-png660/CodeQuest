class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n=nums.length;
        int lastOne=-1;
        for(int i=0;i<n;i++) {
             if(nums[i]==1) {
                if(lastOne==-1) {
                    lastOne=i;
                }
                else {
                    int diff=i-lastOne-1;
                    if(diff<k) {
                        return false;
                    }
                    lastOne=i;
                }
             }
        }
        return true;
    }
}