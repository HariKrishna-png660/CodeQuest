class Solution {
    public boolean checkOnesSegment(String s) {
        int n=s.length();
        int prevIndex=-1;
        for(int i=0;i<n;i++) {
           char ch=s.charAt(i);
           if(ch=='1') {
               if(i-prevIndex!=1) {
                  return false;
               }
               prevIndex=i;
           }
        }
        return true;
    }
}