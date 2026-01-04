class Solution {
    public long lastInteger(long n) {
        long rem=n;
        long diff=1;
        boolean left=true;
        long head=1;
        while(rem>1) {
            if(!left) {
                if(rem%2==0) {
                   head += (diff);
                }
            }
               rem=(rem+1)/2;
               diff *=2;
               left=!left;
        }
        return head;
    }
}