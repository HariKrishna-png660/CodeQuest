class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int si=0;
        int ei=letters.length-1;
        char ans='.';
        while(si<=ei) {
            int mid=(si+ei)/2;
            if(letters[mid]<=target) {
                si=mid+1;
            }
            else {
                ans=letters[mid];
                ei=mid-1;
            }
        }
        return ans=='.'?letters[0]:ans;
    }
}