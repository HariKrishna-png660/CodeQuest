class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> dp[]=new HashMap[n];
        int ans=2;
        for(int i=0;i<n;i++) {
            dp[i]=new HashMap<>();
            for(int j=i-1;j>=0;j--) {
                int d=nums[i]-nums[j];
                int len=dp[j].getOrDefault(d,1)+1;
                dp[i].put(d,Math.max(dp[i].getOrDefault(d,0),len));
                ans=Math.max(ans,dp[i].get(d));
            }
        }
        return ans;
    }
}