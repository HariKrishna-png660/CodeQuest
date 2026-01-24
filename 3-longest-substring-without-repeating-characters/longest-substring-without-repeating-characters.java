class Solution {
    public int lengthOfLongestSubstring(String str) {
        int n=str.length();
    int si=0;
    int ei=0;
    int maxLen=0;
    int count=0;
    int freq[]=new int[128];
    while(ei<n) {
      if(freq[str.charAt(ei)]==1) {
            count++;
      }
      freq[str.charAt(ei)]++;
      ei++;
      while(count>0) {
         if(freq[str.charAt(si)]==2) {
             count--;
          }
         freq[str.charAt(si)]--;
         si++;
      }
      maxLen=Math.max(maxLen,ei-si);
    }
    return maxLen;

    }
}