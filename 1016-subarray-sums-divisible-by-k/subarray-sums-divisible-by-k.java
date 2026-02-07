class Solution {
    public int subarraysDivByK(int[] nums, int k) {
         int n=nums.length;
         HashMap<Integer,Integer> map=new HashMap<>();
         map.put(0,1);
         int subArraysCount=0;
         int currSum=0;
         for(int i=0;i<n;i++) {
              currSum +=(nums[i]);
              if(map.containsKey(((currSum%k)+k)%k)) {
                 subArraysCount += map.get(((currSum%k)+k)%k);
              }
              map.put(((currSum%k)+k)%k,map.getOrDefault(((currSum%k)+k)%k,0)+1);
         }
         return subArraysCount;
    }
}