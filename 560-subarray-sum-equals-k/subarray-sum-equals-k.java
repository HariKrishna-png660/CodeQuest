class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int subarrayCount=0;
        int currSum=0;
        for(int i=0;i<n;i++) {
            currSum += nums[i];
            if(map.containsKey(currSum-k)) {
                subarrayCount += map.get(currSum-k);
            }
           map.put(currSum,map.getOrDefault(currSum,0)+1);
        }
        return subarrayCount;
    }
}