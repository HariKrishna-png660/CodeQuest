class Solution {
    // recursive solution will get tle ......
    // static int numberOfWays;
    // public void numDecodings(String str,String psf) {
    //     if(str.length()==0) {
    //         numberOfWays++;
    //         return;
    //     }
    //     // leading zero case
    //     if(str.charAt(0)=='0') {
    //         return;
    //     }
    //     int digit=str.charAt(0)-'0';
    //     char cChar=(char)('a'+(digit-1));

    //     String remString=str.substring(1);
    //     numDecodings(remString,psf+cChar);

    //     if(str.length()>=2) {
    //         String first2Characters=str.substring(0,2);

    //         int firstTwoDigits=Integer.parseInt(first2Characters);
    //         if(firstTwoDigits<=26) {
    //               cChar=(char)('a'+(firstTwoDigits-1));
    //               remString=str.substring(2);
    //               numDecodings(remString,psf+cChar);
    //         }
    //     }
    // }
    // memoization solution .......
    public int numDecodings(int idx,String str,int dp[]) {
        if(idx==str.length()) {
            return dp[idx]=1;
        }
        if(str.charAt(idx)=='0') {
            return dp[idx]=0;
        }
        if(dp[idx]!=-1) {
            return dp[idx];
        }
        int singleCharWays=numDecodings(idx+1,str,dp);
        int twoCharWays=0;
        if(idx+1<str.length()) {
            int numUsing2Chars=10*(str.charAt(idx)-'0')+(str.charAt(idx+1)-'0');

            if(numUsing2Chars <=26) {
                twoCharWays=numDecodings(idx+2,str,dp);
            }
        }
        return dp[idx]=singleCharWays+twoCharWays;
    }
    public int numDecodings(String s) {
        // numberOfWays=0;
        // numDecodings(s,"");
        // return numberOfWays;
        int n=s.length();
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return numDecodings(0,s,dp);
    }
}