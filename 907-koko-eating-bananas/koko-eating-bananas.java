class Solution {
    // this is simply minimize the maximum .....
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
        int si=1;   // this is the minimum possible speed with which koko can eat 
        int ei=(int)(1e9);  // this is the maximum possible speed with which koko can eat
        int ans=0;     
        while(si<=ei) {
            int mid=(si+ei)/2;
            if(isPossible(piles,mid,h)) {
                ans=mid;
                ei=mid-1;   // try to get the better minimum 
            }
            else {
                si=mid+1;    //  try to search in the right side ....
            }
        }
        return ans;
    }
}