class Solution {
    public int trap(int[] height) {
        // find the left max and right max for every index 
        // the min of both the max is the capacity of water it can hold
        // also the we subtract the height of the each bar 
        int n=height.length;
        int leftMax[]=new int[n];
        int rightMax[]=new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++) {
             leftMax[i]=Math.max(leftMax[i-1],height[i-1]);
        }
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--) {
            rightMax[i]=Math.max(rightMax[i+1],height[i+1]);
        }
        int trapWater=0;
        for(int i=1;i<n-1;i++) {
            int minHeight=Math.min(rightMax[i],leftMax[i]);
            if((minHeight-height[i])>0) {
                trapWater += (minHeight-height[i]);
            }
        }
        return trapWater;
    }
}