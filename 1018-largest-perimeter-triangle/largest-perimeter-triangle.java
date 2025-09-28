class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        for(int i=n-1;i>=2;i--) {
            int firstSide=nums[i];
            int secondSide=nums[i-1];
            int thirdSide=nums[i-2];
            if(firstSide+secondSide > thirdSide && firstSide+thirdSide > secondSide && secondSide+thirdSide > firstSide) {
                return firstSide+secondSide+thirdSide;
            }
        }
        return ans;
    }
}