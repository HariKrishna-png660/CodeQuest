class Solution {
    public String reverseString(String s) {
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        for(int i=n-1;i>=0;i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public String decimalToBinary(int n) {
        StringBuilder sb=new StringBuilder();
        while(n>0) {
            int rem=n%2;
            n=n/2;
            sb.append(rem);
        }
        return sb.toString();
    }
    public int binaryGap(int n) {
        String binary=reverseString(decimalToBinary(n));
        int m=binary.length();
        int maxDist=0;
        int prev=-1;
        for(int i=0;i<m;i++) {
              if(prev==-1 && binary.charAt(i)=='1') {
                  prev=i;
              }
              else if(binary.charAt(i)=='1') {
                 maxDist=Math.max(maxDist,i-prev);
                 prev=i;
              }
        }
        return maxDist;
    }
}