class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int dp0=0;
        int dp1=-(prices[0]+fee);
        for(int i=1;i<n;i++) {
            dp0=Math.max(dp0,dp1+prices[i]);
            dp1=Math.max(dp1,dp0-(prices[i]+fee));
        }
        return dp0;
    }
}