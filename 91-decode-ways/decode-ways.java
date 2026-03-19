class Solution {
    public boolean isValid(String curr) {
         if(curr.charAt(0) != '0' && Integer.parseInt(curr) <= 26) {
                 return true;
         }
         return false;
    }
    public int numDecodings(int idx,String s,String curr,int dp[]) {
        if(idx==0) {
            if(isValid(curr)) {
                 return 1;
            }
            return 0;
        }
        if(curr.length() > 0 && !isValid(curr)) {
            return 0;
        }
        if(dp[idx] != -1) {
            return dp[idx];
        }
        int ways=0;
        if(idx-1 >= 0) {
            ways += numDecodings(idx-1,s,s.substring(idx-1,idx),dp);
        }
        if(idx-2 >= 0) {
            ways += numDecodings(idx-2,s,s.substring(idx-2,idx),dp);
        }
        return dp[idx]=ways;
    }
    public int numDecodings(String s) {
       int n=s.length();
       int dp[]=new int[n+1];
       Arrays.fill(dp,-1);
       return numDecodings(n,s,"",dp);
    }
}