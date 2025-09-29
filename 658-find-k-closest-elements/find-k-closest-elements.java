class Solution {
    public int binarySearch(int arr[],int target) {
        int n=arr.length;
        int si=0;
        int ei=n-1;
        while(si<ei) {
            int mid=(si+ei)/2;
            if(arr[mid]<target) {
                si=mid+1;
            }
            else {
                ei=mid;
            }
        }
        return ei;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        List<Integer> list=new ArrayList<>();
        for(int val:arr) {
            list.add(val);
        }
        if(x<arr[0]) {
            return list.subList(0,k);
        }
        if(x>arr[n-1]) {
            return list.subList(n-k,n);
        }

        int idx=binarySearch(arr,x);

        int si=Math.max(0,idx-k);
        int ei=Math.min(n-1,idx+k);
        while((ei-si+1)>k) {
            if((x-arr[si])<=(arr[ei]-x)) {
                ei--;
            }
            else {
                si++;
            }
        }
        return list.subList(si,ei+1);
    }
}