class Solution {
    public boolean isMatch_rec(String s,String p,int n,int m,Boolean dp[][]) {
        if(n==0 || m==0) {
            if(n==0 && m==0)  return dp[n][m]=true;
            else if(m==1 && p.charAt(m-1)=='*') return dp[n][m]=true;
            return dp[n][m]=false;
        }
        if(dp[n][m]!=null)  return dp[n][m];
        boolean res=false;
        if((s.charAt(n-1) == p.charAt(m-1)) || p.charAt(m-1) == '?') {
            res=isMatch_rec(s,p,n-1,m-1,dp);
        }
        else if(p.charAt(m-1)=='*') {
            res= isMatch_rec(s,p,n-1,m,dp) || isMatch_rec(s,p,n,m-1,dp);
        }
        return dp[n][m]=res;
    }
    public String removeConsecutiveStars(String p) {
        int n=p.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++) {
            char ch=p.charAt(i);
            while(i<p.length() && p.charAt(i)=='*') {
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
        // System.out.println(p);
        Boolean dp[][]=new Boolean[n+1][m+1];
        return isMatch_rec(s,p,n,m,dp);
    }
}