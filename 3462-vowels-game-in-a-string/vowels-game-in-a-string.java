class Solution {
    public int countVowels(String str) {
        int ans=0;
        for(int i=0;i<str.length();i++) {
            char ch=str.charAt(i);
            if(ch=='a'|| ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                ans++;
            }
        }
        return ans;
    }
    public boolean doesAliceWin(String s) {
        int n=s.length();
        int vowelCount=countVowels(s);
        if(vowelCount==0) {
            return false;
        }
        else {
            return true;
        }
    }
}