class Solution {
    public boolean[][] makeIsPalindrome(String s) {
        int n=s.length();
        
        boolean dp[][]=new boolean[n][n];

        for(int gap=0;gap<n;gap++) {
            for(int i=0,j=gap;j<n;i++,j++) {
                if(i==j) {
                    dp[i][j]=true;
                    continue;
                }
                else if(i+1==j) {
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
        return dp;
    }
    public int minCut_rec(String s,int idx,boolean isPalindrome[][],int dp[]) {
         if(isPalindrome[idx][s.length()-1]==true) {
               return dp[idx]=0;
         }
         if(dp[idx]!=0) {
            return dp[idx];
         }
         int res=(int)(1e8);
         for(int cut=idx;cut<s.length();cut++) {
            if(isPalindrome[idx][cut]) {
                res=Math.min(res,minCut_rec(s,cut+1,isPalindrome,dp)+1);
            }
         }
         return dp[idx]=res;
    }
    public int minCut_tab(String s,boolean isPalindrome[][],int dp[]) {
         for(int idx=s.length()-1;idx>=0;idx--) {
              if(isPalindrome[idx][s.length()-1]) {
                  dp[idx]=0;
                  continue;
              }

              int res=(int)(1e8);
              for(int cut=idx;cut<s.length();cut++) {
                   if(isPalindrome[idx][cut]) {
                        res=Math.min(res,dp[cut+1]+1);
                   }
              }
              dp[idx]=res;
         }
         return dp[0];
    }
    public int minCut(String s) {
        boolean isPalindrome[][]=makeIsPalindrome(s);
        int dp[]=new int[s.length()];
        // return minCut_rec(s,0,isPalindrome,dp);
        return minCut_tab(s,isPalindrome,dp);
    }
}