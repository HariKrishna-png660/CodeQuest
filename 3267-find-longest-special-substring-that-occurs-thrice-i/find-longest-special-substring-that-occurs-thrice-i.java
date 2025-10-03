class Solution {
    // =====================BRUTE FORCE APPROACH ======================================================================================
    // TIME COMPLEXITY -> O(N^3)    
    // generating substring will take O(N^2)
    // sb.toString() complexity is O(N)
    // SPACE COMPLEXITY -> O(N^2)
    // hashmap stores n strings 
    // "aaaa" 
    // "a" "aa" "aaa" "aaaa" 
    // lengths of the strings are 1+2+3+4=n*(n+1)/2 O(n^2)
    // public int maximumLength(String s) {
    //     HashMap<String,Integer> map=new HashMap<>();
    //     int n=s.length();
    //     for(int i=0;i<n;i++) {
    //         StringBuilder sb=new StringBuilder();
    //         for(int j=i;j<n;j++) {
    //             if(sb.length()==0 || sb.charAt(sb.length()-1)==s.charAt(j)) {
    //                 sb.append(s.charAt(j)); 
    //                 map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
    //             }
    //             else {
    //                 break;
    //             }
    //         }
    //     }
    //     int ans=0;
    //     for(String key:map.keySet()) {
    //         int val=map.get(key);
    //         if(val>=3) {
    //             ans=Math.max(key.length(),ans);
    //         }
    //     }
    //     return ans==0?-1:ans;
    // }
    // ===============================
    // TIME COMPLEXITY IS O(N^2)
    // class Pair {
    //     char ch;
    //     int count;
    //     public Pair(char ch,int count) {
    //         this.ch=ch;
    //         this.count=count;
    //     }
    //     @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (!(o instanceof Pair)) return false;
    //     Pair p = (Pair) o;
    //     return this.ch == p.ch && this.count == p.count;
    // }

    // @Override
    // public int hashCode() {
    //     return 31 * ch + count;
    // }
    // }
    // public int maximumLength(String s) {
    //    int n=s.length();
    //    HashMap<Pair,Integer> map=new HashMap<>();
    //    for(int i=0;i<n;i++) {
    //        StringBuilder sb=new StringBuilder();
    //        for(int j=i;j<n;j++) {
    //           if(sb.length()==0 || sb.charAt(sb.length()-1)==s.charAt(j)) {
    //             sb.append(s.charAt(j));
    //             int count=sb.length();
    //             char ch=sb.charAt(0);
    //             Pair p=new Pair(ch,count);
    //             map.put(p,map.getOrDefault(p,0)+1);
    //           }
    //           else {
    //             break;
    //           }
    //        }
    //    }
    //    int ans=0;
    //    for(Pair key:map.keySet()) {
    //        int val=map.get(key);
    //        if(val>=3) {
    //            ans=Math.max(ans,key.count);
    //        }
    //    }
    //    return ans==0?-1:ans;
    // }
    // ===================OPTIMISED APPROACH=======================================================
    // TIME COMPLEXITY IS O(N)
    // SPACE COMPLEXITY IS O(26*N)
    public int maximumLength(String s) {
        int n=s.length();
        int matrix[][]=new int[26][n+1];
        char prevChar=s.charAt(0);
        int length=0;
        for(int i=0;i<n;i++) {
            char currChar=s.charAt(i);
            if(prevChar==currChar) {
                length+=1;
                matrix[currChar-'a'][length]++;
            }
            else {
                length=1;
                matrix[currChar-'a'][length]++;
                prevChar=currChar;
            }
        }
        int result=-1;
        for(int i=0;i<26;i++){
            int currSum=0;
           for(int j=n;j>=0;j--) {
               currSum += matrix[i][j];
               if(currSum>=3) {
                  result =Math.max(result,j);
                  break;
               }
           }
        }
        return result;
    }
}