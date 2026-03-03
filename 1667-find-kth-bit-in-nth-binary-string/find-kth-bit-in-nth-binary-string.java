class Solution {
    public String invert(String s) {
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++) {
            char ch=s.charAt(i);
            if(ch=='0') {
                sb.append('1');
            }
            else {
                sb.append('0');
            }
        }
        return sb.toString();
    }
    public String reverse(String s) {
        StringBuilder sb=new StringBuilder(s);
        return sb.reverse().toString();
    }
    public String getNthBinaryString(int n) {
        if(n==1) {
            return "0";
        }
        String stringAtnm1=getNthBinaryString(n-1);
        return stringAtnm1+"1"+reverse(invert(stringAtnm1));
    }
    public char findKthBit(int n, int k) {
        String str=getNthBinaryString(n);
        return str.charAt(k-1);
    }
}