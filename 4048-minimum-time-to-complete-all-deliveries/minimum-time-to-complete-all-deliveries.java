class Solution {
    public static long gcd(long a,long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static long lcm(long a,long b) {
        return Math.abs(a * b) / gcd(a, b);
    }
    public boolean isPossible(int[] d, int[] r, long ans) {
    long d1 = d[0], d2 = d[1];
    long r1 = r[0], r2 = r[1];

    long can1 = ans - ans / r1; // available delivery hours for drone 1
    long can2 = ans - ans / r2; // available delivery hours for drone 2

    long totalAvailable = ans - ans /lcm(r1, r2); // hours where at least one drone can work

    return can1 >= d1 && can2 >= d2 && (d1 + d2) <= totalAvailable;
}
    // binary search can be applied here that is minimize the maximum kind of 
    public long minimumTime(int[] d, int[] r) {
        long low=1;
        long high=(long)1e18;
        long ans=0;
        while(low<=high) {
            long mid=(low+high)/2;
            if(isPossible(d,r,mid)) {
                ans=mid;
                high=mid-1;
            }
            else {
               low=mid+1;
            }
        }
        return ans;
    }
}