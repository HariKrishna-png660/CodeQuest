class Solution {
    public int longestBeautifulSubstring(String word) {
        int n=word.length();
        int maxLen=0;
        int currLen=1;
        int distinct=1;
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('a',0);
        map.put('e',1);
        map.put('i',2);
        map.put('o',3);
        map.put('u',4);
        for(int i=1;i<n;i++) {
            char curr=word.charAt(i);
            char prev=word.charAt(i-1);
            if(map.get(curr)==map.get(prev)) {
                currLen++;
            }
            else if(map.get(curr)-map.get(prev)==1) {
                distinct++;
                currLen++;
            }
            else {
                currLen=1;
                distinct=1;
            }
            if(distinct==5) {
                maxLen=Math.max(maxLen,currLen);
            }
            // System.out.println(currLen+" "+maxLen+" "+distinct);
        }
        if(distinct==5) {
            maxLen=Math.max(maxLen,currLen);
        }
        return maxLen;
    }
}