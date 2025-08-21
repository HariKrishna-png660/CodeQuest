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
    public int climbStairs(int n,int memo[]) {
        if(n<=2) {
            return memo[n]=n;
        }
        if(memo[n]!=-1) {
            return memo[n];
        }
        int oneStepTaken=climbStairs(n-1,memo);
        int twoStepTaken=climbStairs(n-2,memo);
        int totalStepsTaken=oneStepTaken+twoStepTaken;
        return memo[n]=totalStepsTaken;
    }
    public int climbStairs(int n) {
        int memo[]=new int[n+1];
        Arrays.fill(memo,-1);
        return climbStairs(n,memo);
    }
}