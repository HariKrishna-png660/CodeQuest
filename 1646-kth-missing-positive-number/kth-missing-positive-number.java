class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int index=-1;
        for(int i=0;i<n;i++) {
            int expectedNum=i+1;
            int diff=arr[i]-expectedNum;
            if(diff < k) {
                index=i;
            }
        }
        return index+1+k;
    }
}