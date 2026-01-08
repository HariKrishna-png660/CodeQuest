class Solution {
    public int getSumOfString(String s,int index) {
        int sum=0;
        for(int i=0;i<=index;i++) {
            sum += s.charAt(i);
        }
        return sum;
    }
    public int minimumDeleteSum(int n,int m,String s,String p,int dp[][]) {
        if(n==0 || m==0) {
            return dp[n][m]=(n==0)?getSumOfString(p,m-1):getSumOfString(s,n-1);
        }
        if(dp[n][m]!=-1) {
            return dp[n][m];
        }
        if(s.charAt(n-1)==p.charAt(m-1)) {
           return dp[n][m]=minimumDeleteSum(n-1,m-1,s,p,dp);
        }
        int deleteFromS=minimumDeleteSum(n-1,m,s,p,dp)+s.charAt(n-1);
        int deleteFromP=minimumDeleteSum(n,m-1,s,p,dp)+p.charAt(m-1);
        return dp[n][m]=Math.min(deleteFromS,deleteFromP);
    }
    public int minimumDeleteSum(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
        for(int d[]:dp) {
            Arrays.fill(d,-1);
        }
        return minimumDeleteSum(n,m,s1,s2,dp);
    }
}