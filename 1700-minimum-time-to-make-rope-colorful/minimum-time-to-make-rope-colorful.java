class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n=colors.length();
        int pre=neededTime[0];
        int time=0;
     
        for(int i=1;i<n;i++) {
            char curr=colors.charAt(i);
            char prev=colors.charAt(i-1);
            if(curr==prev) {
                time += Math.min(pre,neededTime[i]);
                pre=Math.max(pre,neededTime[i]);
            }
            else {
               pre=neededTime[i];
            }
        }
        return time;
    }
}