class Solution {
    public List<List<Integer>> makePairs(int[] arr, int target, int si, int ei) {
        int i=si; int j=ei;
        List<List<Integer>> ans = new ArrayList<>();
        while(i < j){
            int sum = arr[i] + arr[j];

            if(sum == target){
                ArrayList<Integer> smallAns = new ArrayList<>();
                smallAns.add(arr[i]);
                smallAns.add(arr[j]);
                ans.add(smallAns);
                // ans.add(Arrays.asList(arr[i],arr[j]));
                i++;
                j--;

                // skipping over already seen elements to remove duplicate pairs
                while(i<j && arr[i-1] == arr[i]) i++;
                while(i<j && arr[j+1] == arr[j]) j--;
            } else if(sum < target){
                i++;
            } else {
                j--;
            }            
        }

        return ans;
    }
    
    // generic function to get triplets
    public List<List<Integer>> threesum(int[] nums, int target, int si, int ei){
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=si; i<=ei; i++){
            // removing duplicate elements
            if(i>si && nums[i-1] == nums[i]) continue;

            int fixedElement = nums[i];

            int updatedTarget = target - fixedElement;

            // returns all two sum pairs
            List<List<Integer>> smallAns = makePairs(nums,updatedTarget,i+1,ei);
            addFixedElement(ans,smallAns,fixedElement);
        }

        return ans;
    }

    public  void addFixedElement(List<List<Integer>> ans, List<List<Integer>> smallAns, int fixedElement){
        for(List<Integer> sAns: smallAns){
            sAns.add(fixedElement);
            ans.add(sAns);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        return threesum(nums,0,0,nums.length-1);
    }
}