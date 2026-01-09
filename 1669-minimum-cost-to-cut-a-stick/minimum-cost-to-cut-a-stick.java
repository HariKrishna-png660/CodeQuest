class Solution {
    public static int minCost(int si,int ei,int cuts[],int dp[][],int n) {
          if(dp[si][ei]!=0) {
             return dp[si][ei];
          }
          int leftEnd=si==0?0:cuts[si-1];
          int rightEnd=ei==cuts.length-1?n:cuts[ei+1];
          int costToCut=rightEnd-leftEnd;
          int res=Integer.MAX_VALUE;
          for(int cut=si;cut<=ei;cut++) {
             int left=cut==si?0:minCost(si,cut-1,cuts,dp,n);
             int right=cut==ei?0:minCost(cut+1,ei,cuts,dp,n);
             int curr_ans=left+right+costToCut;
             res=Math.min(res,curr_ans);
          }
          return dp[si][ei]=res;
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int len=n;
        int cutLength=cuts.length;
        int dp[][]=new int[cutLength][cutLength];
        return minCost(0,cuts.length-1,cuts,dp,len);
    }
}