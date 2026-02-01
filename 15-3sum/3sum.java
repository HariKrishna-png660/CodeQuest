class Solution {
    public void findTwoSum(int arr[],int start,int end,List<List<Integer>> ans,int num,int target) {
        int n=arr.length;
        while(start<end) {
            int sum=arr[start]+arr[end];
            if(sum==target) {
                ans.add(new ArrayList<>(Arrays.asList(num,arr[start],arr[end])));
                start++;
                end--;
                  while(start>0 && start<end && arr[start-1]==arr[start]) {
                    start++;
                  }
                  while(end<n-1 && end>start && arr[end+1]==arr[end]) {
                     end--;
                   }
           }
            else if(sum<target) {
                 start++;
            }
            else {
                 end--;
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        // FIX EACH OF THE ELEMENT AND THEN SEARCH FOR THE TWO SUM THAT GET THE REQ TARGET FROM THE REMAINING ELEMENTS
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        // fix the curr element 
        for(int i=0;i<n;i++) {
            if(i!=0 && nums[i-1]==nums[i]) {
                continue;
            }
            int elementAtI=nums[i];
            findTwoSum(nums,i+1,n-1,ans,elementAtI,-elementAtI);
        }
        return ans;
    }
}