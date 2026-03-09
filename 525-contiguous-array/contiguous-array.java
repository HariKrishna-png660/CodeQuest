class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxLen=0;
        int currSum=0;
        map.put(currSum,-1);
        for(int i=0;i<n;i++) {
            if(nums[i]==0) {
                currSum--;
            }
            else {
                currSum++;
            }
            if(map.containsKey(currSum)) {
                maxLen=Math.max(maxLen,i-map.get(currSum));
            }
            else {
                map.put(currSum,i);
            }
        }
        return maxLen;
    }
}