class Solution {
     // recursive solution .....
    // time complexity is O(2^n)
    // space complexity is O(n)
    // public int climbStairs(int n) {
    //     if(n<=2) {
    //         return n;
    //     }
    //     int oneStepTaken=climbStairs(n-1);
    //     int twoStepsTaken=climbStairs(n-2);
    //     int totalSteps=oneStepTaken+twoStepsTaken;
    //     return totalSteps;
    // }
    // ==============================================
    // memoization solution .......
    // time complexity is O(n)
    // space complexity is recursive space O(n) + memo array is O(n) = O(2n) = O(n)
    // public int climbStairs(int n,int memo[]) {
    //     if(n<=2) {
    //         return memo[n]=n;
    //     }
    //     if(memo[n]!=-1) {
    //         return memo[n];
    //     }
    //     int oneStepTaken=climbStairs(n-1,memo);
    //     int twoStepTaken=climbStairs(n-2,memo);
    //     int totalStepsTaken=oneStepTaken+twoStepTaken;
    //     return memo[n]=totalStepsTaken;
    // }
    // public int climbStairs(int n) {
    //    int memo[]=new int[n+1];
    //     Arrays.fill(memo,-1);
    //     return climbStairs(n,memo);
    // }
    // ================================================
    // tabulation solution .....
    // time complexity is O(n)
    // space complexity is O(n)
    //  public int climbStairs(int n,int tab[]) {
    //     for(int i=1;i<=n;i++) {
    //         if(i<=2) {
    //             tab[i]=i;
    //             continue;
    //         }
    //         int oneStep=tab[i-1];
    //         int twoStep=tab[i-2];
    //         tab[i]=oneStep+twoStep;
    //     }
    //     return tab[n];
    //  }
    //  int tab[]=new int[n+1];
    //   return climbStairs(n,tab);
    // public int climbStairs(int n) {
    //    int tab[]=new int[n+1];
    //    return climbStairs(n,tab);
    // } 
    // =======================================
    // time complexity is O(n)
    // space complexity is O(1)
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        for(int i=0;i<dp.length;i++) {
            if(i<=2) {
               dp[i]=i;
               continue;
            }
            if(dp[i]!=0) {
                return dp[i];
            }
            int oneStep=dp[i-1];
            int twoSteps=dp[i-2];
            dp[i]=oneStep+twoSteps;
        }
        return dp[n];
    } 
}