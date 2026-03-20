class Solution {
    public int findInsertionIndex(int arr[],int k) {
        int n=arr.length;
        int si=0;
        int ei=n-1;
        int ans=-1;
        while(si <= ei) {
            int mid=(si+ei)/2;
            if(arr[mid]<k) {
                ans=mid;
                si=mid+1;
            }
            else {
                ei=mid-1;
            }
        }
        return ans;
    }
    public int findKthPositive(int[] arr, int k) {
         int n=arr.length;
         int diff[] =new int[n];
         for(int i=1;i<=n;i++) {
            diff[i-1]=arr[i-1]-i;
         }
         int index=findInsertionIndex(diff,k);
         return index+k+1;
    }
}