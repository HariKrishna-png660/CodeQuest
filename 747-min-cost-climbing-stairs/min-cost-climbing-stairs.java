class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int lastStep=0;
        int secondLastStep=0;
        int n=cost.length;
        for(int i=2;i<n;i++) {
            int current=Math.min(lastStep+cost[i-2],secondLastStep+cost[i-1]);
            lastStep=secondLastStep;
            secondLastStep=current;
        }
        return Math.min(lastStep+cost[n-2],secondLastStep+cost[n-1]);
    }
}