class Solution {
    public int jump_rec(int nums[],int index,int dp[]) {
        if(index==nums.length-1) {
            return dp[nums.length-1]=0;
        }
        if(dp[index]!=-1) {
            return dp[index];
        }
        int minJumps=Integer.MAX_VALUE;
        for(int i=1;i<=nums[index];i++) {
            if(i+index<nums.length) {
                int nextJumps=jump_rec(nums,i+index,dp);
                if(nextJumps!=Integer.MAX_VALUE) {
                  minJumps=Math.min(minJumps,nextJumps+1);
                }
            }
        }
        return dp[index]=minJumps;
    }
    public int jump(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return jump_rec(nums,0,dp);
    }
}