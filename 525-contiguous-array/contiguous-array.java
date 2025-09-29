class Solution {
    public int findMaxLength(int[] nums) {
       int n=nums.length;
       int maxLen=0;
       int currSum=0;
       HashMap<Integer,Integer> map=new HashMap<>();
       map.put(currSum,-1);
       for(int i=0;i<n;i++) {
           int val=nums[i];
           if(val==0) {
            currSum+=-1;
           }
           else {
            currSum+=1;
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