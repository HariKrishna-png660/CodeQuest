class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int firstNext=1;
        int secondNext=0;
        for(int i=n-1;i>=0;i--) {
            if(s.charAt(i)=='0') {
                secondNext=firstNext;
                firstNext=0;
                continue;
            }
            int current=firstNext;
            if(i+2<=n) {
                  String sub=s.substring(i,i+2);
                  int val=Integer.parseInt(sub);
                   if(val<=26) {
                      current += secondNext;
                    }
            }
            secondNext=firstNext;
            firstNext=current;
        }
        return firstNext;
    }
}