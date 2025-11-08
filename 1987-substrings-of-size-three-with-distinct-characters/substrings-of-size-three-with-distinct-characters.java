class Solution {
    public boolean isGoodString(String str) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<=2;i++) {
           map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        return map.size()==3;
    }
    public int countGoodSubstrings(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n-2;i++) {
            String sub=s.substring(i,i+3);
            if(isGoodString(sub)) {
                ans++;
            }
        }
        return ans;
    }
}