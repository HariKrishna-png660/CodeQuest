class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        int count[]=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for(int i=1;i<n;i++) {
            for(int j=i-1;j>=0;j--) {
                if(nums[j]<nums[i]) {
                    if(dp[i]<dp[j]+1) {
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }
                    else if(dp[i]==dp[j]+1) {
                        count[i]+=count[j];
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++) {
            max=Math.max(max,dp[i]);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(dp[i]==max) {
                ans.add(i);
            }
        }
        int  nlis=0;
        for(int val:ans) {
            nlis += count[val];
        }
       return nlis;
    }
}