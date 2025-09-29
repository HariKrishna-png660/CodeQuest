class Solution {
    public boolean isPossible(int arr[],int min,int h) {
        long count=0;
        for(int i=0;i<arr.length;i++) {
            count += (arr[i]/min);
            if(arr[i]%min!=0) {
                count++;
            }
        }
        if(count<=(int)(h)) {
            return true;
        }
        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int si=1;
        int ei=(int)(1e9);
        int ans=0;
        while(si<=ei) {
            int mid=(si+ei)/2;
            if(isPossible(piles,mid,h)) {
                ans=mid;
                ei=mid-1;
            }
            else {
                si=mid+1;
            }
        }
        return ans;
    }
}