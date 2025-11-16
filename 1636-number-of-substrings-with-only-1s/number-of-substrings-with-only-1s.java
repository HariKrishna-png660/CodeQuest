class Solution {
    public int numSub(String s) {
        long ans=0;
        long n=s.length();
        boolean f=false;
        long currLen=0;
        for(int i=0;i<n;i++) {
            char ch=s.charAt(i);
            if(ch=='1') {
                  currLen++;
            }
            else {
                 ans += ((currLen*(currLen+1)/2)%(1000000007));
                 currLen=0;
            }
        }
        ans += ((currLen*(currLen+1)/2)%(1000000007));
        return (int) ans;
    }
}