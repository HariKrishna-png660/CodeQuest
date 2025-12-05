class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int currSum=0;
        map.put(0,1);
        int count=0;
        for(int i=0;i<n;i++) {
            currSum += nums[i];
            if(map.containsKey(currSum-k)) {
                count += map.get(currSum-k);
            }
            if(map.containsKey(currSum)) {
                map.put(currSum,map.getOrDefault(currSum,0)+1);
            }
            if(!map.containsKey(currSum)) {
                map.put(currSum,1);
            }
        }
       return count;
    }
}