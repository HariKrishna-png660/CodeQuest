class Solution {
    public int getFirstIndex(String str,char ch) {
        int n=str.length();
        for(int i=0;i<n;i++) {
            if(str.charAt(i)==ch) {
                return i;
            }
        }
        return -1;
    }
    public int getLastIndex(String str,char ch) {
        int n=str.length();
        for(int i=n-1;i>=0;i--) {
            if(str.charAt(i)==ch) {
                return i;
            }
        }
        return -1;
    }
    public int getUniquePalindromicSubSequencesCount(String str,int start,int end) {
        Set<Character> set=new HashSet<>();
        for(int i=start+1;i<end;i++) {
             set.add(str.charAt(i));
        }
        return set.size();
    }
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        Set<Character> set=new HashSet<>();
        for(int i=0;i<n;i++) {
            set.add(s.charAt(i));
        }
        int count=0;
        for(Character ch:set) {
            int firstIndex=getFirstIndex(s,ch);
            int lastIndex=getLastIndex(s,ch);
            if(firstIndex==lastIndex) {
                continue;
            }
            int strCount=getUniquePalindromicSubSequencesCount(s,firstIndex,lastIndex);
            count += strCount;
        }
        return count;
    }
}