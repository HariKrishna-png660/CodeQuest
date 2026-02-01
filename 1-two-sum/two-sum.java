class Solution {
    public int[] twoSum(int[] nums, int target) {
         int n=nums.length;
         HashMap<Integer,Integer> map=new HashMap<>();
         map.put(nums[0],0);
         for(int i=1;i<n;i++) {
            int req=target-nums[i];
            if(map.containsKey(req)) {
                return new int[]{i,map.get(req)};
            }
            map.put(nums[i],i);
         }
         return new int[]{-1,-1};
    }
}