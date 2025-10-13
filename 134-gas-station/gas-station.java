class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_extra=0;
        int curr_extra=0;
        int start=0;
        for(int i=0;i<gas.length;i++) {
            total_extra += (gas[i]-cost[i]);
            curr_extra += (gas[i]-cost[i]);
            if(curr_extra<0) {
                start=i+1;
                curr_extra=0;
            }
        }
        if(total_extra<0) {
            return -1;
        }
        return start;
    }
}