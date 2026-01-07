class Solution {
    static int MOD=1000000007;
    public int numDecodings(String s) {
        int n=s.length();
        long firstNextStep=1;
        long secondNextStep=0;
        for(int i=n-1;i>=0;i--) {
            char ch1=s.charAt(i);
            long current=0;
              if(ch1!='0') {
                   current=(ch1=='*' ? 9*firstNextStep:firstNextStep);
                    current=current%MOD;
               if(i+1<n) {
                char ch2=s.charAt(i+1);
                if(ch2=='*' && ch1=='*') {
                    current += (15*secondNextStep);
                     current=current%MOD;
                }
                else if(ch2=='*' && ch1=='1') {
                   current += 9*secondNextStep;
                   current=current%MOD;
                }
                else if(ch2=='*' && ch1=='2') {
                    current += 6*secondNextStep;
                    current=current%MOD;
                }
                else if(ch1=='*') {
                    current += (ch2<='6' ? 2*secondNextStep :secondNextStep);
                      current=current%MOD;
                }
                else if(ch2=='*' && ch1>='3') {

                }
                else {
                    String sub=s.substring(i,i+2);
                    int val=Integer.parseInt(sub);
                    if(val<=26) {
                        current += (secondNextStep);
                    }
                     current=current%MOD;
                }
            }
              }
            secondNextStep=firstNextStep;
            firstNextStep=current;
        }
        return (int)firstNextStep%MOD;
    }
}