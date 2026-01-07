class Solution {
    //  (i,j) -> (i+1,j) and (i,j-1) 
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int dp[][]=new int[n][n];
         int maxLen=0;
        for(int diag=0;diag<n;diag++) {
            for(int i=0,j=diag;j<n;j++,i++) {
                if(diag==0) {
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                    if(s.charAt(i)==s.charAt(j)) {
                        dp[i][j]=2+dp[i+1][j-1];
                    }
                }
                maxLen=Math.max(maxLen,dp[i][j]);
            }
        }
      return maxLen;
    }
}