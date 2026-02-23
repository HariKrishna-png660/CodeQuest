class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // store the occurences of each char in s1 in hash map 
        int n=s1.length();
        int m=s2.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            char ch=s1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> dup=new HashMap<>(map);
        int si=0;
        int ei=0;
        while(ei<m) {
            char ch=s2.charAt(ei);
            if(!dup.containsKey(ch) && map.containsKey(ch)) {
                while(s2.charAt(si)!=ch) {
                   dup.put(s2.charAt(si),dup.getOrDefault(s2.charAt(si),0)+1);
                   si++;
                }
                si++;
                if(map.size()==0) {
                    return true;
                }
            }
            else if(!dup.containsKey(ch)) {
                 si=ei+1;
                 dup=new HashMap<>(map);
            }
            else {
                int val=dup.get(ch);
                if(val==1) {
                    dup.remove(ch);
                }
                else {
                    dup.put(ch,val-1);
                }
            }
            ei++;
            if(dup.size()==0) {
                return true;
            }
        }
        return false;
    }
}