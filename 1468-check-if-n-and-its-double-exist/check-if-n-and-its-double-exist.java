class Solution {
    public boolean isPossible(int arr[],int tar,int excludeIndex) {
        int si=0;
        int ei=arr.length-1;
        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] == tar) {
               
                if (mid != excludeIndex) return true;
                
                if (mid > 0 && arr[mid - 1] == tar) return true;
                if (mid < arr.length - 1 && arr[mid + 1] == tar) return true;
                return false;
            } else if (arr[mid] < tar) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return false;
    }
    public boolean checkIfExist(int[] arr) {
         int n=arr.length;
         Arrays.sort(arr);
         for(int i=0;i<n;i++) {
             if(isPossible(arr,arr[i]*2,i)) {
                return true;
             }
         }
         return false;
    }
}