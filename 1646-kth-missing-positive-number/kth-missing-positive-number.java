class Solution {
    // example
    //  0 1 2 3 4
    // given array:[2,3,4,7,11]
    // original   :[1,2,3,4,5]
    // diff       :[1,1,1,3,6]
    // should check the maximum value of diff less than k.
    // ans is that index+1+k
    //     public int findKthPositive(int[] arr, int k) {
    //     int ans=-1;
    //     for(int i=0;i<arr.length;i++) {
    //         int expectedNum=i+1;
    //         int diff=arr[i]-expectedNum;
    //         if(diff<k) {
    //             ans=i;
    //         }
    //         else {
    //             break;
    //         }
    //     }
    //     return ans+k+1;
    // }
    // using binary search 
    public int findKthPositive(int arr[],int k) {
          int n=arr.length;
          int si=0;
          int ei=n-1;
          int ans=-1;
          while(si<=ei) {
             int mid=(si+ei)/2;
             int expectedNum=mid+1;
             int diff=arr[mid]-expectedNum;
             if(diff<k) {
                ans=mid;
                si=mid+1;
             }
             else {
                ei=mid-1;
             }
          }
          return ans+1+k;
    }
}