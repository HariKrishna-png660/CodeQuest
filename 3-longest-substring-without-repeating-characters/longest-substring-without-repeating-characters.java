class Solution {
    public int lengthOfLongestSubstring(String s) {
         int n=s.length();
         int si=0;
         int ei=0;
         int count=0;
         int maxlen=0;
         int freq[]=new int[128];
         while(ei<n) {
            if(freq[s.charAt(ei)]==1) {
                count++;
            }
            freq[s.charAt(ei)]++;
            ei++;
            while(count>0) {
                if(freq[s.charAt(si)]==2) {
                    count--;
                }
                freq[s.charAt(si)]--;
                si++;
            }
            maxlen=Math.max(maxlen,ei-si);
         }
         return maxlen;
    }
}