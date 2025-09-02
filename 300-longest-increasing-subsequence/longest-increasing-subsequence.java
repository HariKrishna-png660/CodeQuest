class Solution {
    // time complexity is nlogn
    public int findInsertionIndex(ArrayList<Integer> lis,int ele) {
        int start=0;
        int end=lis.size()-1;
         while(start<=end) {
            int mid=(start+end)/2;
            if(lis.get(mid)==ele) {
                return mid;
            }
            else if(lis.get(mid)<ele) {
                start=mid+1;
            }
            else {
                end=mid-1;
            }
         }
         return start;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> lis=new ArrayList<>();
        for(int i=0;i<n;i++) {
            int ele=nums[i];
            int idx=findInsertionIndex(lis,ele);
            if(idx==lis.size()) {
                lis.add(ele);
            }
            else {
                lis.set(idx,ele);
            }
        }
        return lis.size();
    }
}