class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        int currSum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxLength=0;
        map.put(0,-1);
        for(int i=0;i<n;i++) {
            if(nums[i]==0) {
                currSum += -1;
            }
            else {
                currSum += 1;
            }
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