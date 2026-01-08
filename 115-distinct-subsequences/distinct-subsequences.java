class Solution {
    public int numDistinct(int n,int m,String s,String t,int dp[][]) {
        if(m==0) {
            return 1;
        }
        if(n<m) {
            return 0;
        }
        if(dp[n][m]!=-1) {
            return dp[n][m];
        }
        int count=0;
        if(s.charAt(n-1)==t.charAt(m-1)) {
           count = numDistinct(n-1,m-1,s,t,dp)+numDistinct(n-1,m,s,t,dp);
        }
        else {
            count = numDistinct(n-1,m,s,t,dp);
        }
        return dp[n][m]=count;
    }
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int d[]:dp) {
            Arrays.fill(d,-1);
        }
        return numDistinct(n,m,s,t,dp);
    }
}