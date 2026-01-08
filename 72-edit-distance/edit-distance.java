class Solution {
    public int minDistance(int n,int m,String s1,String s2,int dp[][]) {
          if(n==0 ||m==0) {
             return dp[n][m]=(n==0) ? m:n;
          }
          if(dp[n][m]!=-1) {
            return dp[n][m];
          }
          if(s1.charAt(n-1)==s2.charAt(m-1)) {
             return dp[n][m]=minDistance(n-1,m-1,s1,s2,dp);
          }
          int insert=minDistance(n,m-1,s1,s2,dp);
          int delete=minDistance(n-1,m,s1,s2,dp);
          int replace=minDistance(n-1,m-1,s1,s2,dp);
          return dp[n][m]=Math.min(insert,Math.min(delete,replace))+1;
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];
        for(int d[]:dp) {
             Arrays.fill(d,-1);
        }
        return minDistance(n,m,word1,word2,dp);
    }
}