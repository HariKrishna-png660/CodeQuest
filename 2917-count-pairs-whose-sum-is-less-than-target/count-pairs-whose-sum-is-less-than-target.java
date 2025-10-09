class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int n=nums.size();
        int count=0;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int sum=nums.get(i)+nums.get(j);
                if(sum<target) {
                    count++;
                }
            }
        }
        return count;
    }
}