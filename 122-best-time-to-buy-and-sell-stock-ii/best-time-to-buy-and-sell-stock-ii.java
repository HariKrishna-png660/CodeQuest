class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp0=0;
        int dp1=-prices[0];
        for(int i=1;i<n;i++) {
            dp0=Math.max(dp0,dp1+prices[i]); // i am going to sell the stock or i will not 
            dp1=Math.max(dp1,dp0-prices[i]); // i am going to buy the stock or i will not 
        }
        return dp0;
    }
}