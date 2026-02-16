class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];
        for(int j=0;j<=m;j++) {
            for(int i=0;i<=n;i++) {
                if(i==0) {
                    dp[i][j]=j;  // when first word is empty and second word contains some letters 
                    continue;
                }
                if(j==0) {
                    dp[i][j]=i; // when second word is empty and first word contains some letters
                    continue;
                }
                dp[i][j]=dp[i-1][j-1];
                if(word1.charAt(i-1)!=word2.charAt(j-1)) {
                    dp[i][j]=Math.min(dp[i][j],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        return dp[n][m];
    }
}