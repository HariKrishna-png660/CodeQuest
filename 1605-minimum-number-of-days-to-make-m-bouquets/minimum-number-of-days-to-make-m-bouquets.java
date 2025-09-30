class Solution {
    // this is a problem in which we need to minimize the maximum
    public boolean isPossible(int bloomDay[],int min,int m,int k) {
        int n=bloomDay.length;
        int count=0;
        for(int i=0;i<n;i++) {
            int val=bloomDay[i];
            if(val<=min) {
                count++;
                if(count==k) {
                    m--;
                    count=0;
                }
            }
            else {
                count=0;
            }
        }
        return m<=0;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int si=1;
        int ei=(int)(1e9);
        int minDay=-1;
        while(si<=ei) {
            int mid=(si+ei)/2;
            if(isPossible(bloomDay,mid,m,k)) {
                minDay=mid;
                ei=mid-1;
            }
            else {
                si=mid+1;
            }
        }
        return minDay;
    }
}