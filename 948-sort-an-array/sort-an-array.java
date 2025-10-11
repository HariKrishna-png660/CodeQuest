class Solution {
    // MERGE SORT IMPLEMENTATION 
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
    // QUICK SORT IMPLEMENTATION =====
    // public void swap(int i,int j,int arr[]) {
    //     int temp=arr[i];
    //     arr[i]=arr[j];
    //     arr[j]=temp;
    // }
    // public int partition(int nums[],int si,int ei) {
    //     int pivot=nums[ei];
    //     int i=si;int j=si;
    //     while(j<=ei-1) {
    //         if(nums[j]<=pivot) {
    //             swap(i,j,nums);
    //             i++;
    //         }
    //         j++;
    //     }
    //     swap(i,ei,nums);
    //     return i;
    // }
    // public void quickSort(int nums[],int si,int ei) {
    //     if(si>ei) {
    //         return;
    //     }
    //     int pivotIndex=partition(nums,si,ei);
    //     quickSort(nums,si,pivotIndex-1);
    //     quickSort(nums,pivotIndex+1,ei);
    // }
    // public int[] sortArray(int[] nums) {
    //     int n=nums.length;
    //      quickSort(nums,0,n-1);
    //      return nums;
    // }
}