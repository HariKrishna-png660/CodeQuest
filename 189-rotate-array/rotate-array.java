class Solution {
    public void reverseArray(int arr[],int start,int end) {
         int i=start;
         int j=end;
         while(i<j) {
            int elementAtI=arr[i];
            int elementAtJ=arr[j];
            arr[i]=elementAtJ;
            arr[j]=elementAtI;
            i++;
            j--;
         }
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        if(k<0) {
            k=k+n;
        }
        // reverse the entire array
        reverseArray(nums,0,n-1);
        // reverse the first k elements 
        reverseArray(nums,0,k-1);
        // reverse the last k elements
        reverseArray(nums,k,n-1);
    }
}