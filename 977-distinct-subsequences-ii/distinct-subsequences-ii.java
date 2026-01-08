class Solution {
    public int distinctSubseqII(String s) {
        int n=s.length();
        long mod=(long)(1e9+7);
        long dp[]=new long[n+1];
        dp[0]=1L;
        int loc[]=new int[26];
        Arrays.fill(loc,-1);
        for(int i=1;i<=n;i++) {
            char ch=s.charAt(i-1);
            long res=(2*dp[i-1])%mod;
            int lastOcurrence=loc[ch-'a'];
            if(lastOcurrence != -1) {
               res=((res-dp[lastOcurrence-1])+mod)%mod;
            }
            loc[ch-'a']=i;
            dp[i]=res;
        }
        return (int)(((dp[n]-1)+mod)%mod);
    }
}