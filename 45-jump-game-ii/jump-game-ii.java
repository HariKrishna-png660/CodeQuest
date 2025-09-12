class Solution {
    public int jump_memo(int nums[],int dp[],int index,int n) {
        if(index==n) {
            return 0;
        }
        if(dp[index]!=-1) {
            return dp[index];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<=nums[index];i++) {
            if(index+i<=n) {
                int next=jump_memo(nums,dp,index+i,n);
                if(next!=Integer.MAX_VALUE) {
                   ans=Math.min(ans,next+1);
                } 
            }
        }
        return dp[index]=ans;
    }
    public int jump(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return jump_memo(nums,dp,0,n-1);
    }
}