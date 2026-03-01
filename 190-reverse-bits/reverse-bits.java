class Solution {
    public int reverseBits(int n) {
       String str=Integer.toBinaryString(n);
       StringBuilder sb=new StringBuilder(str);
       while(sb.length()<32) {
          sb.insert(0,'0');
       }
       return Integer.parseInt(sb.reverse().toString(),2);
    }
}