class Solution {
    public int findKthPositive(int[] arr, int k) {
        int ans=-1;
        for(int i=0;i<arr.length;i++) {
            int expectedNum=i+1;
            int diff=arr[i]-expectedNum;
            if(diff<k) {
                ans=i;
            }
            else {
                break;
            }
        }
        return ans+k+1;
    }
}