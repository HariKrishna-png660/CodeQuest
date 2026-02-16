class Solution {
    public int findNumberOfLIS(int[] nums) {
        // intially the value in the dp and count array are 1 
        // main logic is at index j we need to find out the count of lis 
        // 0 1 2 3 ..... j-2 j-1 j
        // let say indices 2 4 7 9 11 are those which are less than the current idx value
        // THEN STARTING FROM THE INDEX 11 TILL 2 WILL CHECK FOR THE LIS
        // IF THE LENGTH OF LIS IS LARGER THAN THE PRESENT THEN INITILISE THE LIS LENGTH WITH THAT 
        // IF THE LIS LENGTH IS EQUAL THEN ADD THE COUNT OF THE LIS 
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
                    count[i] += count[j];
                 }
              }
            }
        }
        int maxLen=0;
        for(int i=0;i<n;i++) {
            maxLen=Math.max(maxLen,dp[i]);
        }
        int numberOfLis=0;
        for(int i=0;i<n;i++) {
            if(dp[i]==maxLen) {
                numberOfLis += count[i];
            }
        }
        return numberOfLis;
    }
}