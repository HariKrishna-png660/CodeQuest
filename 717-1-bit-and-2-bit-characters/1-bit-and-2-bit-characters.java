class Solution {
    public boolean isOneBitCharacter(int[] bits) {
         int n=bits.length;
         int i=0;
         while(i<n-1) {
            int currVal=bits[i];
            if(currVal==0) {
                i++;
            }
            else {
                i += 2;
            }
         }
         return i==n-1;
    }
}