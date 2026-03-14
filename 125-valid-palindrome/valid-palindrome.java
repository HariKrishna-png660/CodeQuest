class Solution {
    public boolean isAlphaNumeric(char ch) {
        if(ch>='A' && ch<='Z') {
            return true;
        }
        else if(ch>='a' && ch<='z') {
            return true;
        }
        else if(ch>='0' && ch<='9') {
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        int n=s.length();
        int i=0;
        int j=n-1;
        while(i<j) {
            while(i<n && (s.charAt(i)==' ' || !isAlphaNumeric(s.charAt(i)))) {
                i++;
            }
            while(j>=0 && (s.charAt(j)==' ' || !isAlphaNumeric(s.charAt(j)))) {
                j--;
            }
            if(i>j) {
                break;
            }
            char charAtI=Character.toLowerCase(s.charAt(i));
            char charAtJ=Character.toLowerCase(s.charAt(j));
            if(charAtI!=charAtJ) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}