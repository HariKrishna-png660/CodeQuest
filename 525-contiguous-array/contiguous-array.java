class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int currentSum=0;
        map.put(0,-1);
        int maxLen=0;
        for(int i=0;i<n;i++) {
            if(nums[i]==0) {
                currentSum -= 1;
            }
            else {
                currentSum += 1;
            }
            if(map.containsKey(currentSum)) {
                maxLen=Math.max(maxLen,i-map.get(currentSum));
            }
            if(!map.containsKey(currentSum)) {
                map.put(currentSum,i);
            }
        }
        return maxLen;
    }
}