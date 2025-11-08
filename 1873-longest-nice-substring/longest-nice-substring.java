class Solution {
    public boolean isNiceSubString(String str) {
        int n=str.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            char ch=str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char key:map.keySet()) {
            int val1=map.get(key);
            if(Character.isUpperCase(key)) {
                char lowerCase=Character.toLowerCase(key);
                if(!map.containsKey(lowerCase)) {
                    return false;
                }
            }
            else {
                char upperCase=Character.toUpperCase(key);
                if(!map.containsKey(upperCase)) {
                    return false; 
                }
            }
        }
        return true;
    }
    public String longestNiceSubstring(String s) {
        // generate all the substrings
        int n=s.length();
        int maxLen=0;
        String maxStr="";
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<=n;j++) {
                String sub=s.substring(i,j);
                // System.out.println(sub);
                if(isNiceSubString(sub)) {
                    if(maxLen<sub.length()) {
                        maxLen=Math.max(maxLen,sub.length());
                        maxStr=sub;
                    }
                }
            }
        }
        return maxStr;
    }
}