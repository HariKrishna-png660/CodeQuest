class Solution {
    public int minimumCost(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=1;i<nums.length;i++) {
            ans.add(nums[i]);
        }
        Collections.sort(ans);
        return nums[0]+ans.get(0)+ans.get(1);
    }
}