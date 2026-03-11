class Solution {
    public String getComplement(String str) {
        int n=str.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++) {
            char ch=str.charAt(i);
            if(ch=='0') {
                sb.append(1);
            }
            else {
                sb.append(0);
            }
        }
        return sb.toString();
    }
    public int bitwiseComplement(int n) {
        String s=Integer.toBinaryString(n);
        String comp=getComplement(s);
        return Integer.parseInt(comp,2);
    }
}