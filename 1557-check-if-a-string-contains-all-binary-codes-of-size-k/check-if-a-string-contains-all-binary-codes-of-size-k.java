class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n=s.length();
        int end=(int)Math.pow(2,k);
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<=n-k;i++) {
            String sub=s.substring(i,i+k);
            set.add(sub);
        }
        return set.size()==end?true:false;
    }
}