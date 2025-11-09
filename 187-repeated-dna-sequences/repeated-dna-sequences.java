class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n=s.length();
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<=n-10;i++) {
            String sub=s.substring(i,i+10);
            map.put(sub,map.getOrDefault(sub,0)+1);
        }
        List<String> ans=new ArrayList<>();
        for(String key:map.keySet()) {
            int val=map.get(key);
            if(val!=1) {
                ans.add(key);
            }
        }
        return ans;
    }
}