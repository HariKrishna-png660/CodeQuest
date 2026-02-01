class Solution {
    public List<List<Integer>> twoSum(int nums[],int target,int si,int ei) {
        int n=nums.length;
        int low=si;
        int high=ei;
        List<List<Integer>> ans=new ArrayList<>();
        while(low<high) {
            int sum=nums[low]+nums[high];
            if(sum==target) {
               ans.add(new ArrayList<>(Arrays.asList(nums[low],nums[high])));
               low++;
               high--;
               while(low>0 && low<high && nums[low-1]==nums[low]) {
                   low++;
               }
               while(high<n-1 && high > low && nums[high+1]==nums[high]) {
                   high--;
               }
            }
            else if(sum<target) {
                low++;
            }
            else {
                high--;
            }
        }
        return ans;
    }
    public List<List<Integer>> kSum(int nums[],int target,int k,int si,int ei) {
        if(k==2) {
            return twoSum(nums,target,si,ei);
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
    public void addFixedElement(List<List<Integer>> ans,List<List<Integer>> smallAns,int value) {
        for(List<Integer> sAns:smallAns) {
            sAns.add(value);
            ans.add(sAns);
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
         Arrays.sort(nums);

         return kSum(nums,0,3,0,nums.length-1);
    }
}