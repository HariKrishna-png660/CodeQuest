class Solution {
    public long validSubstringCount(String word1, String word2) {
        int n=word2.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            char ch=word2.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> org=new HashMap<>(map);
        int m=word1.length();
        int si=0;
        int ei=0;
        long count=0;
        int freq[]=new int[128];
        while(ei<m) {
             char ch=word1.charAt(ei);
             if(map.containsKey(ch)) {
                int val=map.get(ch);
                if(val==1) {
                    map.remove(ch);
                }
                else {
                    map.put(ch,val-1);
                }
             }
             else if(org.containsKey(ch)) {
                freq[ch]++;
             }
             ei++;
             while(ei-si>=n && map.size()==0) {
                count += (m-ei+1);
                char c1=word1.charAt(si);
                if(org.containsKey(c1)){
                    if(freq[c1] > 0){
                        freq[c1]--;
                    }
                    else{
                        map.put(c1,map.getOrDefault(c1,0)+1);
                    }
                }
                si++;
             }
             System.out.println(count+" "+si+" "+ei);

        }
        return count;
    }
}