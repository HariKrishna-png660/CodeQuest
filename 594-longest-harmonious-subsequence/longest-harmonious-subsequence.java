class Solution {
    public int findLHS(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int key:map.keySet()) {
            list.add(key);
        }
         int maxLen=0;
        for(int i=0;i<list.size();i++) {
           for(int j=i+1;j<list.size();j++) {
                 if(Math.abs(list.get(i)-list.get(j))==1) {
                     int curr=map.get(list.get(i));
                     int next=map.get(list.get(j));
                     maxLen=Math.max(maxLen,curr+next);
                 }
           }
        }
        return maxLen;
    }
}