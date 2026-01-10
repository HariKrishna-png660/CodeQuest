class Solution {
    public int findInsertionIndex(ArrayList<Integer> lis,int ele) {
        int n=lis.size();
        int si=0;
        int ei=n-1;
        int ans=n;
        while(si<=ei) {
            int mid=(si+ei)/2;
            if(lis.get(mid)>=ele) {
                ans=mid;
                ei=mid-1;
            }
            else {
                si=mid+1;
            }
        } 
        return ans;
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