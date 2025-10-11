class Solution {
    // public int binarySearch(int arr[],int target) {
    //     int n=arr.length;
    //     int si=0;
    //     int ei=n-1;
    //     while(si<ei) {
    //         int mid=(si+ei)/2;
    //         if(arr[mid]<target) {
    //             si=mid+1;
    //         }
    //         else {
    //             ei=mid;
    //         }
    //     }
    //     return ei;
    // }
    // public List<Integer> findClosestElements(int[] arr, int k, int x) {
    //     int n=arr.length;
    //     List<Integer> list=new ArrayList<>();
    //     for(int val:arr) {
    //         list.add(val);
    //     }
    //     if(x<arr[0]) {           // if the target element is smaller than all the elements in the array 
    //         return list.subList(0,k);
    //     }
    //     if(x>arr[n-1]) {         // if the target element is greater than all the elements in the array
    //         return list.subList(n-k,n);
    //     }

    //     int idx=binarySearch(arr,x);  // find the insertion position of the target element

    //     int si=Math.max(0,idx-k);  // if there are no enough elements forward 
    //     int ei=Math.min(n-1,idx+k); // if there are no extra elements backward 
    //     while((ei-si+1)>k) {  // take the window with k+1 elements forward and k+1 elements backward 
    //         if((x-arr[si])<=(arr[ei]-x)) {   // minimizing the window by moving  ei towards left
    //             ei--;
    //         }
    //         else {    // minimizing the window by moving si towards right 
    //             si++;
    //         }
    //     }
    //     return list.subList(si,ei+1);
    // }
    public int binarySearch(int arr[],int tar) {
        int n=arr.length;
        int si=0;
        int ei=n-1;
        while(si<=ei) {
          int mid=(si+ei)/2;
          if(arr[mid]==tar) {
            return mid;
          }
          else if(arr[mid]<tar) {
            si=mid+1;
          }
          else {
            ei=mid-1;
          }
        }
        return ei;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++) {
            list.add(arr[i]);
        }
        if(x<arr[0]) {
            return list.subList(0,k);
        }
        else if(x>arr[n-1]) {
            return list.subList(n-k,n);
        } 
        int idx=binarySearch(arr,x);
        int si=Math.max(0,idx-k);
        int ei=Math.min(n-1,idx+k);
        while((ei-si+1)>k) {
            if((x-arr[si]) <= (arr[ei]-x)) {
                ei--;
            }
            else {
                si++;
            }
        }
        return list.subList(si,ei+1);
    }
}