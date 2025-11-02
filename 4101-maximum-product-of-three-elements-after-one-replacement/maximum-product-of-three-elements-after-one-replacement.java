class Solution {
    public long maxProduct(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++) {
            int absValue=Math.abs(nums[i]);
            list.add(absValue);
        }
        Collections.sort(list);
        return (long)list.get(n-1)*list.get(n-2)*(long)(1e5);
    }
}