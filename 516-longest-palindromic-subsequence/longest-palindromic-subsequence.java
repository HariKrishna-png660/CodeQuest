class Solution {
    public int longestPalindromeSubseq(String s,int si,int ei,int dp[][]) {
        if(si>ei) {
            return 0;
        }
        if(si==ei) {
            return dp[si][ei]=1;
        }
        if(dp[si][ei]!=-1) {
            return dp[si][ei];
        }
        if(s.charAt(si)==s.charAt(ei)) {
            return dp[si][ei]=longestPalindromeSubseq(s,si+1,ei-1,dp)+2;
        }
        return dp[si][ei]=Math.max(longestPalindromeSubseq(s,si,ei-1,dp),longestPalindromeSubseq(s,si+1,ei,dp));
    }
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i],-1);
        }
        return longestPalindromeSubseq(s,0,n-1,dp);
    }
}