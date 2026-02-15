class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int dp[][]=new int[n][n];
        int maxLen=0;
        for(int diag=0;diag<n;diag++) {
            for(int i=0,j=diag;j<n;i++,j++) {
                if(diag==0) {
                    dp[i][j]=1;
                }
                else if(s.charAt(i)==s.charAt(j)) {
                    dp[i][j]=dp[i+1][j-1]+2;
                }
                else {
                   int includeFirst=dp[i][j-1];
                   int excludeFirst=dp[i+1][j];
                   dp[i][j]=Math.max(includeFirst,excludeFirst);
                }
                maxLen=Math.max(maxLen,dp[i][j]);
            }
        }
        return maxLen;
    }
}