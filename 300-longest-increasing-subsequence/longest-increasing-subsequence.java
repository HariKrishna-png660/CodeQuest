class Solution {
    public void findInsertionPosition(ArrayList<Integer> lis,int tar) {
        int n=lis.size();
        int low=0;
        int high=n-1;
        while(low<=high) {
            int mid=(low+high)/2;
            if(lis.get(mid)==tar) {
                low=mid;
                break;
            }
            else if(lis.get(mid)<tar) {
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        if(low==n) {
            lis.add(n,tar);
        }
        else {
            lis.set(low,tar);
        }
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++) {
            findInsertionPosition(list,nums[i]);
        }
        return list.size();
    }
}