class Solution {
    public boolean isDivisor(int div,int num) {
        if(div==0) {
            return false;
        }
        return num%div==0;
    }
    public int divisorSubstrings(int num, int k) {
        String str=num+"";
        int n=str.length();
        int ans=0;
        for(int i=0;i<=n-k;i++) {
            String sub=str.substring(i,i+k);
            if(isDivisor(Integer.parseInt(sub),num)) {
                 ans++;
            }
        }
        return ans;
    }
}