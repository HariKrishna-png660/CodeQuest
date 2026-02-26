class Solution {
    public boolean queryString(String s, int m) {
        int n=s.length();
        for(int i=1;i<=m;i++) {
            String str=Integer.toBinaryString(i);
            if(!s.contains(str)) {
                return false;
            }
        }
        return true;
    }
}