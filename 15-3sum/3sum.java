class Solution {
    public List<List<Integer>> makePairs(int nums[],int target,int si,int ei) {
        int i=si;
        int j=ei;
        List<List<Integer>> ans=new ArrayList<>();
        while(i<j) {
            int sum=nums[i]+nums[j];
            if(sum==target) {
               List<Integer> smallAns=new ArrayList<>();
               smallAns.add(nums[i]);
               smallAns.add(nums[j]);
               ans.add(smallAns);
               i++;
               j--;

               while(i<j && nums[i-1]==nums[i]) i++;
               while(i<j && nums[j+1]==nums[j]) j--; 
            }
            else if(sum<target) {
                i++;
            }
            else {
                j--;
            }
        }
        return ans;
    }
    public void addFixedElement(List<List<Integer>> ans,List<List<Integer>> smallAns,int fixedElement) {
        for(List<Integer> sAns:smallAns) {
            sAns.add(fixedElement);
            ans.add(sAns);
        }
    }
    public List<List<Integer>> kSum(int nums[],int target,int k,int si,int ei) {
        if(k==2) {
            return makePairs(nums,target,si,ei);
        }
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=si;i<=ei;i++) {
            if(i>si && nums[i-1]==nums[i]) {
                continue;
            }
            int fixedElement=nums[i];
            int updatedTarget=target-fixedElement;
            List<List<Integer>> smallAns=kSum(nums,updatedTarget,k-1,i+1,ei);
            addFixedElement(ans,smallAns,fixedElement);
        }
        return ans;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return kSum(nums,0,3,0,nums.length-1);
    }
}