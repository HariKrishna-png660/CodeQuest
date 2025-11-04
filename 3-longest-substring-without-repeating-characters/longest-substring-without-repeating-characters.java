class Solution {
    // Sliding window 
    // it has two pointers -> si,ei

    // ei will increase it's value by one every time
    // ei will try to expand the window to maximize the length of the substring
    // ei may also damge the window by adding duplicates 
    
    // si will repair the window by moving any steps forward so that every character occurs once in the window
    public int lengthOfLongestSubstring(String s) {
        // int maxLen=0;
        // int count=0;
        // int n=s.length();
        // int si=0;
        // int ei=0;
        // int freq[]=new int[128];
        // while(ei<n) {
        //     if(freq[s.charAt(ei)]==1) {
        //        count++;
        //     }
        //     freq[s.charAt(ei)]++;
        //     ei++;
        //     while(count>0) {
        //         if(freq[s.charAt(si)]==2) {
        //             count--;
        //         }
        //         freq[s.charAt(si)]--;
        //         si++;
        //     }
        //     maxLen=Math.max(maxLen,ei-si);
        // }
        // return maxLen;
        int n=s.length();
        int si=0;
        int ei=0;
        int count=0;
        int freq[]=new int[128]; // considering all the letters digits symbols and spaces
        int maxLen=0;
        while(ei<n) {
            char ch=s.charAt(ei);
            if(freq[ch]==1) {
                count++;
            }
            freq[ch]++;
            ei++;
            while(count>0) {
                char sch=s.charAt(si);
                if(freq[sch]==2) {
                    count--;
                }
                freq[sch]--;
                si++;
            }
            maxLen=Math.max(maxLen,ei-si);
        }
        return maxLen;
    }
}