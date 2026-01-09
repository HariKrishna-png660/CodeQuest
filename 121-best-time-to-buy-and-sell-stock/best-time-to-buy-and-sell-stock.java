class Solution {
    public int maxProfit(int[] prices) {
       int n=prices.length;
       int dp0=0; // don't buy any stock
       int dp1=-prices[0]; // buy a stock 
       for(int i=1;i<n;i++) {
          dp0=Math.max(dp0,dp1+prices[i]); // rest or sell a stock that brought earlier 
          dp1=Math.max(dp1,-prices[i]);  // rest or buy a stock that is less cost that the cost that we had already
       }
       return dp0;
    }
}