class Solution {
    public boolean isSubstringSatisfying(String sub,int k) {
        int n=sub.length();
        int zeroCount=0;
        int onesCount=0;
        for(int i=0;i<n;i++) {
            char ch=sub.charAt(i);
            if(ch=='0') {
                zeroCount++;
            }
            else {
                onesCount++;
            }
        }
        return (zeroCount<=k)||(onesCount<=k);
    }
    public int countKConstraintSubstrings(String s, int k) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<=n;j++) {
                String sub=s.substring(i,j);
                if(isSubstringSatisfying(sub,k)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}