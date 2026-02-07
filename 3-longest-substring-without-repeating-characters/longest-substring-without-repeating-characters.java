class Solution {
    public int lengthOfLongestSubstring(String str) {
         int n=str.length();
        int si=0;
        int ei=0;
        int maxLength=0;
        String maxString="";
        int count=0;
        int freq[]=new int[128];
        while(ei<n) {
            int currChar=str.charAt(ei);
            if(freq[currChar]==1) {
                count++;
            }
            freq[currChar]++;
            ei++;
            while(count>0) {
                if(freq[str.charAt(si)]==2) {
                    count--;
                }
                freq[str.charAt(si)]--;
                si++;
            }
            int currLength=ei-si;
            String currString=str.substring(si, ei);
            if(currLength>maxLength ) {
               maxLength=currLength;
               maxString=currString;
            }
            else if(currLength==maxLength && currString.compareTo(maxString)<0) {
                 maxString=currString;
            }
        }
        System.out.println(maxString);
        return maxLength;
    }
}