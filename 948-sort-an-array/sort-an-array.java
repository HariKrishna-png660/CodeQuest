class Solution {
    public int[] mergeSortedArrays(int a[],int b[]) {
        int n1=a.length;
        int n2=b.length;
        int res[]=new int[n1+n2];
        int i=0;
        int j=0;
        int k=0;
        while(i<n1 && j<n2) {
            if(a[i]<=b[j]) {
                res[k++]=a[i++];
            }
            else {
                res[k++]=b[j++];
            }
        }
        while(i<n1) {
            res[k++]=a[i++];
        }
        while(j<n2) {
            res[k++]=b[j++];
        }
        return res;
    }
    public int[] mergeSort(int nums[],int si,int ei) {
        if(si==ei) {
            int ba[]=new int[1];
            ba[0]=nums[si];
            return ba;
        }
        int mid=(si+ei)/2;
        int left[]=mergeSort(nums,si,mid);
        int right[]=mergeSort(nums,mid+1,ei);
        return mergeSortedArrays(left,right);
    }
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        return mergeSort(nums,0,n-1);
    }
}