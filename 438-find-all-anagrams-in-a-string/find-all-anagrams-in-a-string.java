class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m=s.length();
        int n=p.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            char ch=p.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int si=0;
        int ei=0;
        HashMap<Character,Integer> dup=new HashMap<>(map);
        List<Integer> ans=new ArrayList<>();
        while(ei<m) {
            char ch=s.charAt(ei);
            if(!dup.containsKey(ch) && map.containsKey(ch)) {
                while(s.charAt(si)!=ch) { 
                    dup.put(s.charAt(si),1);
                    si++;
                }
                si++;
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
            if(dup.size()==0) {
                ans.add(si);
                if(ei+1<n && !map.containsKey(s.charAt(ei+1))) {
                    dup=new HashMap<>(map);
                }
            }
            ei++;
            // System.out.println(dup +" "+ei);
            // System.out.println(ans+" "+ei);
        }
        return ans;
    }
}