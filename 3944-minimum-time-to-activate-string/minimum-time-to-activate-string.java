class Solution {
    public boolean isPossible(String s,int order[],int k,int minTime) {
        int n=s.length();
         int marker[]=new int[n];
         for(int i=0;i<=minTime;i++) {
            marker[order[i]]=1;
         }
         long ans=0;
         long len=0;
         for(int i=0;i<n;i++) {
             if(marker[i]==0) {
                len++;
             }
             else {
                ans += (len*(len+1)/2);
                len=0;
             }
         }
         if(len>0) {
                ans += (len*(len+1))/2;
         }
         long total=((long)n*(n+1))/2; 
         long req=total-ans;
         return req>=k;
    }
    public int minTime(String s, int[] order, int k) {
        int low=0;
        int high=order.length-1;
        int ans=-1;
        while(low<=high) {
            int mid=(low+high)/2;
            if(isPossible(s,order,k,mid)) {
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return ans;
    }
}