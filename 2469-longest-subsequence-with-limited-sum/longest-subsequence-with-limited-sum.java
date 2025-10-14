class Solution {
    public int getMaxSize(int prefix[],int tarSum) {
          int n=prefix.length;
          int ans=0;
          for(int i=0;i<n;i++) {
               if(prefix[i]<=tarSum) {
                  ans=i+1;
               }
               else {
                  break;
               }
          }
          return ans;
    }
    public int[] answerQueries(int[] nums, int[] queries) {
         Arrays.sort(nums);
         int n=nums.length;
         int prefix[]=new int[n];
         prefix[0]=nums[0];
         for(int i=1;i<n;i++) {
            prefix[i] = prefix[i-1]+nums[i];
         }
         int m=queries.length;
         int ans[]=new int[m];
         for(int i=0;i<m;i++) {
             int maxSize=getMaxSize(prefix,queries[i]);
             ans[i]=maxSize;
         }
         return ans;
    }
}