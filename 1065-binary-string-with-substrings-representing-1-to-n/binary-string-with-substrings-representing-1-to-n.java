class Solution {
    public boolean queryString(String s, int n) {
        int k=s.length();
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<k;i++) {
            for(int j=i+1;j<=k;j++) {
                String sub=s.substring(i,j);
                set.add(sub);
            }
        }
        for(int i=1;i<=n;i++) {
            String str=Integer.toBinaryString(i);
            if(!set.contains(str)) {
                return false;
            } 
        }
        // System.out.println(set);
        return true;
    }
}