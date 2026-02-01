class Solution {
    public int binarySearch(int arr[],int tar,int start,int end) {
        int n=arr.length;
        int low=start;
        int high=end;
        int ans=-1;
        while(low<=high) {
            int mid=(low+high)/2;
            if(arr[mid]==tar) {
                ans=mid;
                low=mid+1;
            }
            else if(arr[mid]<tar) {
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return ans;
    }
    public int[] twoSum(int[] numbers, int target) {
        // fix the curr Element and search for the req number by binary search 
        int n=numbers.length;
        // iterate on each of the element in the array
        for(int i=0;i<n;i++) {
            int curr=numbers[i];
            int req=target-curr;
            int index=binarySearch(numbers,req,i,n-1);
            if(index != -1 && index != i) {
                int ans[]=new int[2];
                ans[0]=i+1;
                ans[1]=index+1;
                Arrays.sort(ans);
                return ans;
            }
        }
        return new int[]{-1,-1};
    }
}