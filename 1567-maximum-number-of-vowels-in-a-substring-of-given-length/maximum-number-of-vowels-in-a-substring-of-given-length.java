class Solution {
    public boolean isVowel(char ch) {
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' ||ch=='u') {
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int n=s.length();
        int vowelCount=0;
        int si=0;
        int ei=0;
        int maxVowelCount=0;
        while(ei<n) {
            char currChar=s.charAt(ei);
            if(isVowel(currChar)) {
                vowelCount++;
            }
            ei++;
            while(ei-si>k) {
                char charAtSi=s.charAt(si);
                if(isVowel(charAtSi)) {
                    vowelCount--;
                }
                si++;
            }
            if(ei-si==k) {
                maxVowelCount=Math.max(maxVowelCount,vowelCount);
            }
        }
        return maxVowelCount;
    }
}