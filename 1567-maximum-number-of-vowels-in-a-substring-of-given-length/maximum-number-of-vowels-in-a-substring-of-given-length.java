class Solution {
    // sliding window 
    // ei will move by one step each time
    // if the window gets damaged then si will move forward 
    // int this process try to count max number of vowels.
    // public boolean isVowel(char ch) {
    //     if(ch=='a'||ch=='e' || ch=='i' ||ch=='o' ||ch=='u') {
    //         return true;
    //     }
    //     return false;
    // }
    // public int maxVowels(String s, int k) {
    //    int n=s.length();
    //    int si=0;
    //    int ei=0;
    //    int count=0;
    //    int maxCount=0;
    //    while(ei<n) {
    //        if(isVowel(s.charAt(ei))) {
    //            count++;
    //        }
    //        ei++;
    //        if(ei-si>k) {
    //           if(isVowel(s.charAt(si))) {
    //              count--;
    //           }
    //           si++;
    //        }
    //       maxCount=Math.max(maxCount,count);
    //    }
    //    return maxCount;
    // }
    public boolean isVowel(String s,int i) {
         char ch=s.charAt(i);
         if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
            return true;
         }
         return false;
    }
     public int maxVowels(String s, int k) {
        int n=s.length();
        int si=0;
        int ei=0;
        int maxVowels=0;
        int currVowels=0;
        while(ei<n) {
            if(isVowel(s,ei)) {
                currVowels++;
            }
            ei++;
            if(ei-si>k) {
                if(isVowel(s,si)) {
                    currVowels--;
                }
                si++;
            }
            if(ei-si==k) {
                maxVowels=Math.max(maxVowels,currVowels);
            }
        }
        return maxVowels;
     }
}