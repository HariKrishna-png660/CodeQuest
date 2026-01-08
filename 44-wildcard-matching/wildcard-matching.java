class Solution {
    public boolean isMatch(int n,int m,String s,String p,Boolean dp[][]) {
         if(n==0 || m==0) {
              if(n==0 && m==0) {
                 return dp[n][m]=true;
              }
              else if(m==1 && p.charAt(m-1)=='*') {
                 return dp[n][m]=true;
              }
              return dp[n][m]=false;
         }
         if(dp[n][m]!=null) {
             return dp[n][m];
         }
         boolean res=false;
         if(s.charAt(n-1)==p.charAt(m-1) || p.charAt(m-1)=='?') {
            res=isMatch(n-1,m-1,s,p,dp);
         }
         else if(p.charAt(m-1)=='*') {
            res=isMatch(n-1,m,s,p,dp) || isMatch(n,m-1,s,p,dp);
         }
         return dp[n][m]=res;
    }
    public String removeConsecutiveStars(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++) {
            char ch=s.charAt(i);
            while(i<s.length() && s.charAt(i)=='*') {
                i++;
            }
            sb.append(ch);
            if(ch=='*') {
                i--;
            }
        }
        return sb.toString();
    }
    public boolean isMatch(String s, String p) {
        p=removeConsecutiveStars(p);
        int n=s.length();
        int m=p.length();
        Boolean dp[][]=new Boolean[n+1][m+1];
        return isMatch(n,m,s,p,dp);
    }
}