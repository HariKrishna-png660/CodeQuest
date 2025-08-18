class Solution {
    // memoization solution .....
    public int minCostClimbingStairs(int index,int n,int cost[],int memo[]) {
           if(index==n || index==n-1) {
              return cost[index];
           }
           if(memo[index]!=-1) {
              return memo[index];
           }
           int minCost=Integer.MAX_VALUE;
           if(index+1<=n) {
              minCost=Math.min(minCost,minCostClimbingStairs(index+1,n,cost,memo));
           }
           if(index+2<=n) {
              minCost=Math.min(minCost,minCostClimbingStairs(index+2,n,cost,memo));
           }
           return memo[index]=minCost+cost[index];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int memo[]=new int[n+1];
        for(int i=0;i<memo.length;i++) {
            memo[i]=-1;
        }
        int cost1=minCostClimbingStairs(0,n-1,cost,memo);
        int cost2=minCostClimbingStairs(1,n-1,cost,memo);
        return Math.min(cost1,cost2);
    }
}