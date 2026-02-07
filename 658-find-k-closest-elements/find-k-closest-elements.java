class Solution {
    public int findInsertPosition(int arr[],int tar) {
        int n=arr.length;
        int low=0;
        int high=n-1;
        int pos=n;
        while(low<=high) {
            int mid=(low+high)/2;
            if(arr[mid]==tar) {
                return mid;
            }
            else if(arr[mid]<tar) {
                low=mid+1;
            }
            else {
                pos=mid;
                high=mid-1;
            }
        }
        return pos;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
         int n=arr.length;
         List<Integer> list=new ArrayList<>();
         for(int i=0;i<n;i++) {
            list.add(arr[i]);
         }
         // if the target is less than all the elements in the array
         if(x<arr[0]) {
            return list.subList(0,k);
         }
         // if the target is greater than all the elements in the array
         if(x>arr[n-1]) {
            return list.subList(n-k,n);
         } 
         else {
            int pos=findInsertPosition(arr,x);
            int si=Math.max(0,pos-k);
            int ei=Math.min(n-1,pos+k);
            while((ei-si+1)>k) {
                int elementAtSi=list.get(si);
                int elementAtEi=list.get(ei);
                if(x-elementAtSi <= elementAtEi-x) {
                    ei--;
                }
                else {
                    si++;
                }
            }
            return list.subList(si,ei+1);
         }
    }
}