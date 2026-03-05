class Solution {
    public int minOperations(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++) {
             int curr=s.charAt(i)-'0';
             if(i%2==0) {
                if(curr != 0) {
                    count++;
                }
             }
             else {
                if(curr != 1) {
                    count++;
                }
             }
        }
        return Math.min(count,n-count);
    }
}