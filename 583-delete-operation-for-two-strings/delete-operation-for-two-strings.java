class Solution {
    public int minDistance(String word1,String word2,int n,int m,int dp[][]) {
        if(n==0 || m==0) {
            return n==0?m:n;
        }
        if(dp[n][m]!=-1) {
            return dp[n][m];
        }
        int res=0;
        if(word1.charAt(n-1)==word2.charAt(m-1)) {
            res=minDistance(word1,word2,n-1,m-1,dp);
        }
        else {
            res=Math.min(minDistance(word1,word2,n-1,m,dp),minDistance(word1,word2,n,m-1,dp))+1;
        }
        return dp[n][m]=res;
    }
    public int minDistance(String word1, String word2) {
         int n=word1.length();
         int m=word2.length();
         int dp[][]=new int[n+1][m+1];
         for(int i=0;i<=n;i++) {
            Arrays.fill(dp[i],-1);
         }
         return minDistance(word1,word2,n,m,dp);
    }
}