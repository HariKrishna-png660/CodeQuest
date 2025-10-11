class Solution {
    static int invCount;
    // merge sort 
    public static int[] mergeSortedArrays(int a[],int b[]) {
        int n1=a.length;
        int n2=b.length;
        int res[]=new int[n1+n2];
        int i=0; // pointer for array a
        int j=0; // pointer for array b
        int k=0; // pointer for array res
        while(i<n1 && j<n2) {
            if(a[i]<=b[j]) {
                res[k]=a[i];
                i++;
            }
            else {
                res[k]=b[j];
                j++;
            }
            k++;
        }
        while(i<n1) {
           res[k]=a[i];
           i++;
           k++;
        }
        while(j<n2) {
            res[k]=b[j];
            // even though we try to add invCount += (n1 -i) we will be adding zeros here .....
            j++;
            k++;
        }
        return res;
    }
    public static int[] mergeSort(int arr[],int si,int ei) {
        if(si==ei) {
            int ba[]=new int[1];
            ba[0]=arr[si];
            return ba;
        }
        int mid=(si+ei)/2;
        int left[]=mergeSort(arr,si,mid);
        int right[]=mergeSort(arr,mid+1,ei);
        int j = 0;
        for (int i = 0; i < left.length; i++) {
           while (j < right.length && (long) (left[i]) > 2L* (long)right[j]) {
                  j++;
              }
             invCount += j;
          }
        return mergeSortedArrays(left, right);
    }
    public int reversePairs(int[] nums) {
        invCount=0;
        int n=nums.length;
        mergeSort(nums,0,n-1);
        return invCount;
    }
}