class Solution {
    public int binarySearch(int arr[],int tar) {
         int si=0;
         int ei=arr.length-1;
         while(si<ei) {
            int mid=(si+ei)/2;
            if(arr[mid]<tar) {
                si=mid+1;
            }
            else {
                ei=mid;
            }
         }
         return si;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        List<Integer> ans=new ArrayList<>();
        for(int val:arr) {
            ans.add(val);
        }
        if(x<arr[0]) {
            return ans.subList(0,k);
        }
        else if(x>arr[n-1]) {
            return ans.subList(n-k,n);
        }
        
        int idx=binarySearch(arr,x);
        
        int si=Math.max(0,idx-k);
        int ei=Math.min(idx+k,n-1);

        while((ei-si+1)>k) {
            if((x-arr[si])<=(arr[ei]-x)) {
                ei--;
            }
            else {
                si++;
            }
        }
        return ans.subList(si,ei+1);
    }
}