class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int n=operations.length;
        int x=0;
        for(int i=0;i<n;i++) {
            String str=operations[i];
            int a=0;
            int s=0;
            for(int j=0;j<str.length();j++) {
                 char ch=str.charAt(j);
                 if(ch=='-') {
                    s=1;
                    break;
                 }
                 if(ch=='+') {
                    a=1;
                    break;
                 }
            }
            if(s==1) {
                x--;
            }
            if(a==1) {
                x++;
            }
        }
        return x;
    }
}