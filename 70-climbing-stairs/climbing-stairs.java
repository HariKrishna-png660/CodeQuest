class Solution {
    // memoization solution ..
    public int climbStairs(int n,int memo[]) {
        if(n<0) {
            return 0;
        }
        if(n==0) {
            return 1;
        }
        if(memo[n]!=0) {
            return memo[n];
        }
        int oneStep=climbStairs(n-1,memo);
        int twoSteps=climbStairs(n-2,memo);
        int totalSteps=oneStep+twoSteps;
        return memo[n]=totalSteps;
    }
    public int climbStairs(int n) {
        int memo[]=new int[n+1];
        return climbStairs(n,memo);
    }
}