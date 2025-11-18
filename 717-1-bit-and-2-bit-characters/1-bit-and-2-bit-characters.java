class Solution {
    public boolean isOneBitCharacter(int[] bits) {
         int n=bits.length;
         int index=-1;
         int i=0;
         if(n==1) {
            return true;
         }
         while(i<n) {
            int currVal=bits[i];
            if(currVal==0) {
                i++;
            }
            else {
                i += 2;
            }
            if(i==n-1) {
                index=1;
            }
         }
         return index==-1 ? false:true;
    }
}