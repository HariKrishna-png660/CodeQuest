class Solution {
    public int partitionString(String s) {
        int n=s.length();
        int si=0;
        int ei=0;
        int ans=0;
        int freq[]=new int[128];
        while(ei<n) {
            if(freq[s.charAt(ei)]==1) {
                ans++;
                freq=new int[128];
            }
            freq[s.charAt(ei)]++;
            ei++;
        }
        return ans+1;
    }
}