class Solution {
    public int findKthPositive(int[] arr, int k) {
         int idx=-1;
         for(int i=0;i<arr.length;i++) {
              int en=i+1;
              int diff=arr[i]-en;
              if(diff<k) {
                idx=i;
              }
              else {
                break;
              }
         }
         return idx+k+1;
    }
}