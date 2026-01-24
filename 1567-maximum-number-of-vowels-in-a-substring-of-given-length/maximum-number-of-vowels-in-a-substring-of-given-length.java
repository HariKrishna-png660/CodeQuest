class Solution {
    public boolean isVowel(char ch) {
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
    public int maxVowels(String s, int k) {
        int n=s.length();
        int vowelCount=0;
        int si=0;
        int ei=0;
        int maxVowelCount=0;
        while(ei<n) {
            char charAtEi=s.charAt(ei);
            if(isVowel(charAtEi)) {
                vowelCount++;
            }
            ei++;
            if(ei-si>k) {
                char charAtSi=s.charAt(si);
                if(isVowel(charAtSi)) {
                    vowelCount--;
                }
                si++;
            } 
            maxVowelCount=Math.max(maxVowelCount,vowelCount);
        }
        return maxVowelCount;
    }
}