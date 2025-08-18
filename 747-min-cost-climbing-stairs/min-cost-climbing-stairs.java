class Solution {
    // recursive solution  with proactive calls will give tle ....
    // public int minCostClimbingStairs(int index,int n,int cost[]) {
    //     if(index==n) {
    //         return cost[index];
    //     }
    //     if(index==n-1) {
    //         return cost[index];
    //     }
    //     int minCost=Integer.MAX_VALUE;
    //     if(index+1<=n) {
    //         minCost=Math.min(minCost,minCostClimbingStairs(index+1,n,cost));
    //     }
    //     if(index+2<=n) {
    //         minCost=Math.min(minCost,minCostClimbingStairs(index+2,n,cost));
    //     }
    //     return cost[index]+minCost;
    // }
    // memoization solution .....
    // public int minCostClimbingStairs(int index,int n,int cost[],int memo[]) {
    //        if(index==n || index==n-1) {
    //           return cost[index];
    //        }
    //        if(memo[index]!=-1) {
    //           return memo[index];
    //        }
    //        int minCost=Integer.MAX_VALUE;
    //        if(index+1<=n) {
    //           minCost=Math.min(minCost,minCostClimbingStairs(index+1,n,cost,memo));
    //        }
    //        if(index+2<=n) {
    //           minCost=Math.min(minCost,minCostClimbingStairs(index+2,n,cost,memo));
    //        }
    //        return memo[index]=minCost+cost[index];
    // }
    // tabulation solution ........
    public void minCostClimbingStairs(int n,int cost[],int tab[]) {
        for(int i=n;i>=0;i--) {
            if(i==n || i==n-1) {
                tab[i]=cost[i];
                continue;
            }
            int minCost=Integer.MAX_VALUE;
            if(i+1<=n) {
                minCost=Math.min(minCost,tab[i+1]);
            }
            if(i+2<=n) {
                minCost=Math.min(minCost,tab[i+2]);
            }
            tab[i]=minCost+cost[i];
        }
    }
    public int minCostClimbingStairs(int[] cost) {
        // int n=cost.length;
        // int cost1=minCostClimbingStairs(0,n-1,cost);
        // int cost2=minCostClimbingStairs(1,n-1,cost);
        // return Math.min(cost1,cost2);
        // =============================
        // int n=cost.length;
        // int memo[]=new int[n+1];
        // for(int i=0;i<memo.length;i++) {
        //     memo[i]=-1;
        // }
        // int cost1=minCostClimbingStairs(0,n-1,cost,memo);
        // int cost2=minCostClimbingStairs(1,n-1,cost,memo);
        // return Math.min(cost1,cost2);
        // ===============================
        int n=cost.length;
        int tab[]=new int[n+1];
         minCostClimbingStairs(n-1,cost,tab);
         int cost0=tab[0];
         int cost1=tab[1];
         return Math.min(cost0,cost1);
    }
}