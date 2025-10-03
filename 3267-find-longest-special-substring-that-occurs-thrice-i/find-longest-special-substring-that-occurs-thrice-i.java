class Solution {
    public int maximumLength(String s) {
        HashMap<String,Integer> map=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++) {
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<n;j++) {
                if(sb.length()==0 || sb.charAt(sb.length()-1)==s.charAt(j)) {
                    sb.append(s.charAt(j));
                    map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
                }
                else {
                    break;
                }
            }
        }
        int ans=0;
        for(String key:map.keySet()) {
            int val=map.get(key);
            if(val>=3) {
                ans=Math.max(key.length(),ans);
            }
        }
        return ans==0?-1:ans;
    }
}