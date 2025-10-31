class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int ans[]=new int[2];
        int i=0;
        for(int key:map.keySet()) {
            int value=map.get(key);
            if(value==2) {
                ans[i++]=key;
            }
        }
        return ans;
    }
}