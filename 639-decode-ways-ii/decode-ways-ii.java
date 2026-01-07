class Solution {
    static int MOD=1000000007;
    public int numDecodings(String s) {
        int n=s.length();
        long dp[]=new long[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--) {
            char ch1=s.charAt(i);
            if(ch1=='0') {
                continue;
            }
            dp[i] += (ch1=='*' ? 9*dp[i+1]:dp[i+1]);
            dp[i]=dp[i]%MOD;
            if(i+1<n) {
                char ch2=s.charAt(i+1);
                if(ch2=='*' && ch1=='*') {
                    dp[i] += (15*dp[i+2]);
                     dp[i]=dp[i]%MOD;
                }
                else if(ch2=='*' && ch1=='1') {
                    dp[i] += 9*dp[i+2];
                      dp[i]=dp[i]%MOD;
                }
                else if(ch2=='*' && ch1=='2') {
                    dp[i] += 6*dp[i+2];
                     dp[i]=dp[i]%MOD;
                }
                else if(ch1=='*') {
                    dp[i] += (ch2<='6' ? 2*dp[i+2] :dp[i+2]);
                      dp[i]=dp[i]%MOD;
                }
                else if(ch2=='*' && ch1>='3') {

                }
                else {
                    String sub=s.substring(i,i+2);
                    int val=Integer.parseInt(sub);
                    if(val<=26) {
                        dp[i] += (dp[i+2]);
                    }
                     dp[i]=dp[i]%MOD;
                }
            }
        }
        return (int)dp[0]%MOD;
    }
}