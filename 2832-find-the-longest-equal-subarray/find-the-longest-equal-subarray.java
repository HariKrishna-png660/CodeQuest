class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n=nums.size();
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            map.putIfAbsent(nums.get(i),new ArrayList<>());
            map.get(nums.get(i)).add(i);
        }
        int maxLen=0;
        for(ArrayList<Integer> list:map.values()) {
            int left=0;
            for(int right=0;right<list.size();right++) {
                while( (list.get(right)-list.get(left)+1) - (right-left+1)>k)  {
                      left++;
                }
                maxLen=Math.max(maxLen,right-left+1);
            }
        }
        return maxLen;
    }
}