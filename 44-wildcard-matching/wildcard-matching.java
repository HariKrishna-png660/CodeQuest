class Solution {
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
        boolean dp[][]=new boolean[n+1][m+1];
        for(int j=0;j<=m;j++) {
            for(int i=0;i<=n;i++) {
                if(i==0 || j==0) {
                    if(i==0 && j==0) {
                        dp[i][j]=true;
                        continue;
                    }
                    else if(j==1 && p.charAt(j-1)=='*') {
                        dp[i][j]=true;
                        continue;
                    }
                    dp[i][j]=false;
                }
                else if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1)=='?') {
                     dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*') {
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
}