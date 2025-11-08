class Solution {
    public int getCount(String sub) {
        int bc=0;
        for(int i=0;i<sub.length();i++) {
           char ch=sub.charAt(i);
           if(ch=='B') {
              bc++;
           }
        }
        return bc;
    }
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        int maxCount=0;
        for(int i=0;i<=n-k;i++) {
            String sub=blocks.substring(i,i+k);
            int count=getCount(sub);
            maxCount=Math.max(maxCount,count);
        }
        return k-maxCount;
    }
}