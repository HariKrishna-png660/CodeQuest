class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n=nums.length;
        int si=0;
        int ei=0;
        boolean isFound=false;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(ei<n) {
            int value=nums[ei];
            if(map.containsKey(value)) {
                int val=map.get(value);
                if(ei-val<=k) {
                    isFound=true;
                }
                else {
                    map.put(value,ei);
                }
            }
            else {
                map.put(value,ei);
            }
            ei++;
        }
        return isFound;
    }
}