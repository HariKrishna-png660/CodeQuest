class Solution {
    public List<List<Integer>> makePairs(int arr[],long target,int si,int ei) {
        int i=si;
        int j=ei;
        List<List<Integer>> ans=new ArrayList<>();

        while(i<j) {
            long sum=arr[i]+arr[j];

            if(sum==target) {
                ArrayList<Integer> smallAns=new ArrayList<>();
                smallAns.add(arr[i]);
                smallAns.add(arr[j]);
                ans.add(smallAns);
                i++;
                j--;

                while(i<j && arr[i-1]==arr[i]) i++;
                while(i<j && arr[j+1]==arr[j]) j--;
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
    public List<List<Integer>> kSum(int nums[],long target,int k,int si,int ei) {
        if(k==2) {
            return makePairs(nums,target,si,ei);
        }
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=si;i<=ei;i++) {
            if(i>si && nums[i-1]==nums[i]) {
                continue;
            }
            int fixedElement=nums[i];
            long updatedTarget=target-fixedElement;

            List<List<Integer>> smallAns=kSum(nums,updatedTarget,k-1,i+1,ei);
            addFixedElement(ans,smallAns,fixedElement);
        }
        return ans;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
         Arrays.sort(nums);
         return kSum(nums,target,4,0,nums.length-1);
    }
}