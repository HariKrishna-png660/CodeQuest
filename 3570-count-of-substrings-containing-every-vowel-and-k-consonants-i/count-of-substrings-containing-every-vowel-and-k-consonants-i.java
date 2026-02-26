class Solution {
    public boolean isVowel(char ch) {
        if(ch=='a'||ch=='i' ||ch=='o' ||ch=='u' ||ch=='e') {
            return true;
        }
        return false;
    }
    public boolean isPossible(String s,int si,int ei,int k) {
        HashSet<Character> set=new HashSet<>();
        int consCount=0;
        for(int i=si;i<ei;i++) {
            char ch=s.charAt(i);
            if(isVowel(ch)) {
                set.add(ch);
            }
            else {
                consCount++;
            }
        }
        if(set.size()==5 && consCount==k) {
            return true;
        }
        return false;
    }
    public int countOfSubstrings(String word, int k) {
        int n=word.length();
        int count=0;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<=n;j++) {
                if(isPossible(word,i,j,k)) {
                     count++;
                }
            }
        }
        return count;
    }
}