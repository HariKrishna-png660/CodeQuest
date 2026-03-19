class Solution {
    public int minCostClimbingStairs(int idx,int cost[],int n,int dp[]) {
         if(idx==n) {
            return 0;
         }
         if(dp[idx] != -1) {
            return dp[idx];
         }
         int minCost=Integer.MAX_VALUE;
         if(idx+1 <= n) {
            int oneStep=minCostClimbingStairs(idx+1,cost,n,dp);
            minCost=Math.min(minCost,oneStep);
         }
         if(idx+2 <= n) {
            int twoStep=minCostClimbingStairs(idx+2,cost,n,dp);
            minCost=Math.min(minCost,twoStep);
         }
         return dp[idx]=minCost+cost[idx];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        // System.out.println(minCostClimbingStairs(0,cost,n));
        //  System.out.println(minCostClimbingStairs(1,cost,n));
        return Math.min(minCostClimbingStairs(0,cost,n,dp),minCostClimbingStairs(1,cost,n,dp));
    }
}