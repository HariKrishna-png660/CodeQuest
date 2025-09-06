class Solution {
   
    private long getOperations(long n) {
        long res = 0;
        long ops = 0;
        long powerOfFour = 1;
        
        while (powerOfFour <= n) {
            long l = powerOfFour;
            long r = Math.min(n, powerOfFour * 4 - 1);
            ops++; 
            res += (r - l + 1) * ops;
            powerOfFour *= 4;
        }
        return res;
    }

    public long minOperations(int[][] queries) {
        long total = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
           
            long ops = (getOperations(r) - getOperations(l - 1) + 1) / 2;
            total += ops;
        }
        return total;
    }
}
