class Solution {
    public int numSteps(String s) {
        int n=s.length();
        int ans=0;
        boolean isCarry=false;
        for(int i=n-1;i>=1;i--) {
            char ch=s.charAt(i);
            if(ch=='1') {
                if(isCarry) {
                    ans++;
                }
                else {
                    ans += 2;
                }
                isCarry=true;
            }
            else {
               if(isCarry) {
                   ans += 2;
               }
               else {
                  ans++;
               }
            }
        }
        return isCarry ? (ans+1):ans;
    }
}