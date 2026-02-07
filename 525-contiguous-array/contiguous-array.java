class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int currSum=0;
        int maxLength=0;
        for(int i=0;i<n;i++) {
            currSum += nums[i]==0?-1:1;
            if(map.containsKey(currSum)) {
               maxLength=Math.max(maxLength,i-map.get(currSum));
            }
            else {
                map.put(currSum,i);
            }
        }
        return maxLength;
    }
}