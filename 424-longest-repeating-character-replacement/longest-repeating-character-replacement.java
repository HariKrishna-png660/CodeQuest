class Solution {
    public int longestRepeatingCharacter(String s,int k,char currChar) {
        int si=0;
        int ei=0;
        int maxLen=0;
        int n=s.length();
        // char currChar=' ';
        while(ei<n) {
            if(s.charAt(ei)!=currChar) {
                k--;
                if(k<0) {
                    maxLen=Math.max(maxLen,ei-si);
                    while(k<0) {
                        if(s.charAt(si)!=currChar) {
                         k++;
                        }
                        si++;
                    }
                }
            }
            ei++;
            // System.out.println(si+" "+ei);
        }
           maxLen=Math.max(maxLen,ei-si);
           return maxLen;
    }
    public int characterReplacement(String s, int k) {
        int n=s.length();
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<n;i++) {
            set.add(s.charAt(i));
        }
        int maxLen=0;
        for(char ch:set) {
           maxLen=Math.max(maxLen,longestRepeatingCharacter(s,k,ch));
        }
        return maxLen;
    }
}