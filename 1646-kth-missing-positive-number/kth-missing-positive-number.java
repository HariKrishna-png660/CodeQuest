class Solution {
    public int findInsertionIndex(int arr[],int tar) {
        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high) {
            int mid=(low+high)/2;
            if(arr[mid]<tar) {
                 low=mid+1;
                 ans=mid;
            }
            else {
                 high=mid-1;
            }
        }
        return ans;
    }
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int diff[]=new int[n];
        for(int i=1;i<=n;i++) {
            diff[i-1]=arr[i-1]-i;
        }
        return findInsertionIndex(diff,k)+k+1;
    }
}