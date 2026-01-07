class Solution {
    public void fillValues(boolean dp[][],String s) {
        int n=dp.length;
        // travel digonally 
        for(int diag=0;diag<n;diag++) {
            for(int i=0,j=diag;j<n;i++,j++) {
                if(diag==0) {
                    dp[i][j]=true;
                }
                else if(diag==1) {
                    if(s.charAt(i)==s.charAt(j)) {
                        dp[i][j]=true;
                    }
                 }
                else {
                   if(s.charAt(i)==s.charAt(j)) {
                        dp[i][j]=dp[i+1][j-1];
                   }
                }
            }
        }
    }
    public int countSubstrings(String s) {
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        fillValues(dp,s);
        int count=0;
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(dp[i][j]) {
                   count++;
                }
            }
        }
        return count;
    }
}