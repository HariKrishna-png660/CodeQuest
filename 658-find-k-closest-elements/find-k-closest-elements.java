class Solution {
    public int findInsertionPosition(int arr[],int tar) {
        int n=arr.length;
        int si=0;
        int ei=n-1;
        while(si <= ei) {
            int mid=(si+ei)/2;
            if(arr[mid]==tar) {
                return mid;
            }
            else if(arr[mid] < tar) {
                si=mid+1;
            }
            else {
                ei=mid-1;
            }
        }
        return si;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
          int n=arr.length;
          List<Integer> ans=new ArrayList<>();
          for(int i=0;i<n;i++) {
              ans.add(arr[i]);
          }
          if(x<arr[0]) {
             return ans.subList(0,k);
          }
          else if(x>arr[n-1]) {
            return ans.subList(n-k,n);
          }
          else {
             int pos=findInsertionPosition(arr,x);
             int si=Math.max(0,pos-k);
             int ei=Math.min(n-1,pos+k);
             while((ei-si+1) > k) {
                  int elementAtSi=arr[si];
                  int elementAtEi=arr[ei];
                  if(x-elementAtSi <= elementAtEi-x) {
                     ei--;
                  }
                  else {
                    si++;
                  }
             }
             return ans.subList(si,ei+1);
          }
    }
}