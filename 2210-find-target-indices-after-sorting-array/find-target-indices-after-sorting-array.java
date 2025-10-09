class Solution {
    public int getFirstIndex(int nums[],int target) {
          int ans=-1;
          int si=0;
          int ei=nums.length-1;
          while(si<=ei) {
             int mid=(si+ei)/2;
             if(nums[mid]==target) {
                ans=mid;
                ei=mid-1;
             }
             else if(nums[mid]<target) {
                si=mid+1;
             }
             else {
               ei=mid-1;
             }
          }
          return ans;
    }
    public int getLastIndex(int nums[],int target) {
          int ans=-1;
          int si=0;
          int ei=nums.length-1;
          while(si<=ei) {
              int mid=(si+ei)/2;
              if(nums[mid]==target) {
                   ans=mid;
                   si=mid+1;
              }
              else if(nums[mid]<target) {
                   si=mid+1;
              }
              else {
                   ei=mid-1;
              }
          }
          return ans;
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int firstIndex=getFirstIndex(nums,target);
        int lastIndex=getLastIndex(nums,target);
        List<Integer> ans=new ArrayList<>();
        if(firstIndex==-1) {
            return new ArrayList<>();
        }
        for(int i=firstIndex;i<=lastIndex;i++) {
            ans.add(i);
        }
        return ans;
    }
}