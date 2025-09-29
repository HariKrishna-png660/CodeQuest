class Solution {
    public boolean isVowel(char ch) {
        if(ch=='a' || ch=='e'|| ch=='i'||ch=='o'||ch=='u') {
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int si=0;
        int ei=0;
        int maxCount=0;
        int count=0;
        int n=s.length();
        while(ei<n) {
            if(isVowel(s.charAt(ei))) {
                count++;
            }
            ei++;
            if(ei-si>k) {
                if(isVowel(s.charAt(si))) {
                    count--;
                }
                si++;
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}