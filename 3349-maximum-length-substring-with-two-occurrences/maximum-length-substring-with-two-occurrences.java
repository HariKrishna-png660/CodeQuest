class Solution {
    public boolean isPossible(String str) {
        int n=str.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            char ch=str.charAt(i);
           map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:map.keySet()) {
            int val=map.get(ch);
            if(val>2) {
                return false;
            } 
        }
        return true;
    }
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int maxLen=0;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<=n;j++) {
                String sub=s.substring(i,j);
                if(isPossible(sub)) {
                    maxLen=Math.max(maxLen,j-i);
                }
            }
        }
        return maxLen;
    }
}