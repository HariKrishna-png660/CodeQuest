class Solution {
    public boolean isVowel(char ch) {
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int n=s.length();
        int si=0;
        int ei=0;
        int maxLen=0;
        int vowelCount=0;
        while(ei<n) {
            if(isVowel(s.charAt(ei))) {
                vowelCount++;
            }
            ei++;
            if(ei-si>k) {
                if(isVowel(s.charAt(si))) {
                    vowelCount--;
                }
                si++;
            }
            if(ei-si==k) {
                maxLen=Math.max(maxLen,vowelCount);
            }
        }
        return maxLen;
    }
}