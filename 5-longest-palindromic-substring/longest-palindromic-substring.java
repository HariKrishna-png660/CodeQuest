class Solution {
    public boolean isPalindrome(String s,int i,int j) {
        while(i<j) {
            char charAtI=s.charAt(i);
            char charAtJ=s.charAt(j);
            if(charAtI != charAtJ) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        // brute force 
        int n=s.length();
        int maxLen=0;
        int si=0;
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(isPalindrome(s,i,j)) {
                    if(j-i+1 > maxLen) {
                        maxLen=j-i+1;
                        si=i;
                    }
                }
            }
        }
        return  s.substring(si,si+maxLen);
    }
}