class Solution {
    public boolean isPossible(int arr[],int m,int k,int v) {
        int count=0;

        for(int i=0;i<arr.length;i++) {
            if(arr[i]<=v) {
                count++;
                if(count==k) {
                   m--;
                   count=0;
               }
            }
            else {
                count=0;
            }
           if(m==0) {
            return true;
           } 
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int min=1;
        int max=(int)(1e9);
        int minDay=-1;
        while(min<=max) {
            int mid=(min+max)/2;
            if(isPossible(bloomDay,m,k,mid)) {
                max=mid-1;
                minDay=mid;
            }
            else {
                min=mid+1;
            }
        }
        return minDay;
    }
}