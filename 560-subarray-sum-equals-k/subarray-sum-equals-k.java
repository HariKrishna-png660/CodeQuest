class Solution {
    public int subarraySum(int[] nums, int k) {
       HashMap<Integer,Integer> map=new HashMap<>();
       int ans=0;
       int currSum=0;
       map.put(currSum,1);
       for(int i=0;i<nums.length;i++) {
           currSum+=nums[i];
           
           ans += map.getOrDefault(currSum-k,0);

           map.put(currSum,map.getOrDefault(currSum,0)+1);
       }
       return ans;
    }
}