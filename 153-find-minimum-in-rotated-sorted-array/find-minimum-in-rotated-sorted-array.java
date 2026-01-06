class Solution {
    // there will be three scenarios possible ->
    // si to mid sorted and mid to ei is unsorted  answer will be in the right area (unsorted)
    // si to mid unsorted and mid to ei is sorted  answer will be in the left area (unsorted)
    // si to mid is sorted and mid to ei is sorted  answer will be in the left area 
    // we only go to right when it is unsorted and remaing cases we go to left
    // going right means si=mid+1
    // going left means ei=mid
    public int findMin(int[] nums) {
        int si=0;
        int ei=nums.length-1;
        while(si<ei) { // tc O(log n)
            int mid=(si+ei)/2;
            if(nums[mid]>nums[ei]) {
                si=mid+1;
            }
            else {
                ei=mid;
            }
            // System.out.print(si+" "+ei);
        }
        return nums[si];
    }
   }