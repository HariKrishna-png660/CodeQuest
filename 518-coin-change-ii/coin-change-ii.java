class Solution {
    // recursive solution - 1 will give tle .....
    // public int coinChangeCombinationMultipleUse(int coins[],int tar,int idx) {
    //     if(target==0) {
    //         return 1;
    //     }
    //     int totalWays=0;
    //         if(target-coins[idx]>=0) {
    //              totalWays += coinChangeCombinationMultipleUse(coins,target-coins[idx],idx);
    //         }

    //      if(idx+1<coins.length) {
    //         totalWays += coinChangeCombinationMultipleUse(coins,target,idx+1);
    //      }
    //    return totalWays;
    // }
    // recursive solution - 2 will give tle ....
    // public int coinChangeCombinationMultipleUse(int coins[],int target,int idx) {
    //     if(target==0) {
    //         return 1;
    //     }
    //     int totalWays=0;
    //     for(int i=idx;i<coins.length;i++) {
    //         if(target-coins[i]>=0) {
    //              totalWays += coinChangeCombinationMultipleUse(coins,target-coins[i],i);
    //         }
    //     }
    //     return totalWays;
    // }
    // memoization solution ..... using 2D dp 
    // public int coinChangeCombinationMultipleUse(int coins[],int target,int memo[],int idx) {
    //     if(target==0) {
    //         return memo[0]=1;
    //     }
    //     if(memo[idx]!=-1) {
    //         return memo[idx];
    //     }
    //     int totalWays=0;
    //     for(int i=idx;i<coins.length;i++) {
    //         if(target-coins[i]>=0) {
    //             totalWays += coinChangeCombinationMultipleUse(coins,target-coins[i],memo,i);
    //         }
    //     }
    //     return memo[target]=totalWays;
    // }
    // memoization solution ..... using 1d dp 
    public int coinChangeCombinationMultipleUse(int coins[],int tar,int memo[][],int idx) {
        if(tar==0) {
            return memo[tar][idx]=1;
        }
        if(memo[tar][idx]!=-1) {
            return memo[tar][idx];
        }
        int totalWays=0;
        if(tar-coins[idx]>=0) {
           totalWays += coinChangeCombinationMultipleUse(coins,tar-coins[idx],memo,idx);
        }
        if(idx+1<coins.length) {
            totalWays += coinChangeCombinationMultipleUse(coins,tar,memo,idx+1);
        }
        return memo[tar][idx]=totalWays;
    }
    public int change(int amount, int[] coins) {
        // return coinChangeCombinationMultipleUse(coins,amount,0);
        // return coinChangeCombinationMultipleUse(coins,amount,0);
        int memo[][]=new int[amount+1][coins.length+1];
        for(int mem[]:memo) {
            Arrays.fill(mem,-1);
        }
        return coinChangeCombinationMultipleUse(coins,amount,memo,0);
    }
}