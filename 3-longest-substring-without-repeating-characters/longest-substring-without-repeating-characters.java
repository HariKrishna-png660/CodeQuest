class Solution {
    // Sliding window 
    // it has two pointers -> si,ei

    // ei will increase it's value by one every time
    // ei will try to expand the window to maximize the length of the substring
    // ei may also damge the window by adding duplicates 
    
    // si will correct the window by moving any steps forward so that every character occurs once in the window
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int si=0;
        int ei=0;
        int count=0;
        int maxLen=0;
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
            maxLen=Math.max(maxLen,ei-si);
        }
        return maxLen;
    }
}