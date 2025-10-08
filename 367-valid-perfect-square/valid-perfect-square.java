class Solution {
    public boolean isPerfectSquare(int num) {
        boolean isFound=false;
        int low=0;
        int high=num;
        while(low<=high) {
            int mid=low +(high-low)/2;
            if((long)mid*mid==num) {
                isFound=true;
                break;
            }
            else if((long)mid*mid<num) {
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return isFound;
    }
}